package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Doctor;
import Model.Operation;

public class ReadOperation {
	
	private Operation o;
	
	public ReadOperation(int ID, Database database) {
		String select = "SELECT * FROM `operations` WHERE `ID` = "+ID+" ;";
		o = new Operation();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			o.setID(rs.getInt("ID"));
			int doctorID = rs.getInt("Doctor");
			o.setDateTime(rs.getString("DateTime"));
			int patientID = rs.getInt("Patient");
			o.setPaid(Boolean.parseBoolean(rs.getString("Paid")));
			o.setDiagnosis(rs.getString("Diagnosis"));
			o.setDoctor((Doctor) new ReadEmployee(doctorID, database).getEmployee());
			o.setPatient(new ReadPatient(patientID, database).getPatient());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Operation getOperation() {
		return o;
	}

}
