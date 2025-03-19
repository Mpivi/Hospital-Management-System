package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Doctor;
import Model.Report;

public class ReadReport {
	
	private Report r;
	
	public ReadReport(int ID, Database database) {
		String select = "SELECT * FROM `reports` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			r = new Report();
			r.setID(rs.getInt("ID"));
			int doctorID = rs.getInt("Doctor");
			int patientID = rs.getInt("Patient");
			r.setDateTime(rs.getString("DateTime"));
			r.setDiagnosis(rs.getString("Diagnosis"));
			r.setTreatment(rs.getString("Treatment"));
			r.setPaid(Boolean.parseBoolean(rs.getString("Paid")));
			r.setPatient(new ReadPatient(patientID, database).getPatient());
			r.setDoctor((Doctor) new ReadEmployee(doctorID, database).getEmployee());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Report getReport() {
		return r;
	}

}
