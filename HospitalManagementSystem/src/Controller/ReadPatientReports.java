package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Doctor;
import Model.Patient;
import Model.Report;

public class ReadPatientReports {
	
	private ArrayList<Report> reports;
	
	public ReadPatientReports(Patient p, Database database) {
		String select = "SELECT * FROM `reports` WHERE `Patient` = "+p.getID()+" ;";
		reports = new ArrayList<>();
		ArrayList<Integer> doctorsIDs = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Report r = new Report();
				r.setID(rs.getInt("ID"));
				doctorsIDs.add(rs.getInt("Doctor"));
				r.setPatient(p);
				r.setDateTime(rs.getString("DateTime"));
				r.setDiagnosis(rs.getString("Diagnosis"));
				r.setTreatment(rs.getString("Treatment"));
				r.setPaid(Boolean.parseBoolean(rs.getString("Paid")));
				reports.add(r);
			}
			for (int i=0;i<reports.size();i++) {
				reports.get(i).setDoctor((Doctor) new ReadEmployee(
						doctorsIDs.get(i), database).getEmployee());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Report> getReports() {
		return reports;
	}

}
