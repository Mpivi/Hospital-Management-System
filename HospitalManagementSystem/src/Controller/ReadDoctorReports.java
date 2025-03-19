package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Doctor;
import Model.Report;

public class ReadDoctorReports {
	
	private ArrayList<Report> reports;
	
	public ReadDoctorReports(Doctor d, Database database) {
		String select = "SELECT * FROM `reports` WHERE `Doctor` = "+d.getID()+" ;";
		reports = new ArrayList<>();
		ArrayList<Integer> patientsIDs = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Report r = new Report();
				r.setID(rs.getInt("ID"));
				r.setDoctor(d);
				patientsIDs.add(rs.getInt("Patient"));
				r.setDateTime(rs.getString("DateTime"));
				r.setDiagnosis(rs.getString("Diagnosis"));
				r.setTreatment(rs.getString("Treatment"));
				r.setPaid(Boolean.parseBoolean(rs.getString("Paid")));
				reports.add(r);
			}
			for (int i=0;i<reports.size();i++) {
				reports.get(i).setPatient(new ReadPatient(
						patientsIDs.get(i), database).getPatient());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Report> getReports() {
		return reports;
	}

}
