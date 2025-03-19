package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Patient;

public class ReadPatient {
	
	private Patient p;
	
	public ReadPatient(int ID, Database database) {
		String select = "SELECT * FROM `patients` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			p = new Patient();
			p.setID(rs.getInt("ID"));
			p.setFirstName(rs.getString("FirstName"));
			p.setLastName(rs.getString("LastName"));
			p.setEmail(rs.getString("Email"));
			p.setPhoneNumber(rs.getString("PhoneNumber"));
			p.setPassword(rs.getString("Password"));
			p.setBloodGroup(rs.getString("BloodGroup"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Patient getPatient() {
		return p;
	}

}
