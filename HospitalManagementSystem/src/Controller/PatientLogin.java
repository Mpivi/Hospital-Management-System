package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Patient;

public class PatientLogin {
	
	private String email, password;
	private Database database;
	private Patient p;
	
	public PatientLogin(String email, String password, Database database) {
		this.email = email;
		this.password = password;
		this.database = database;
	}
	
	public boolean isLoggedIn() {
		String select = "SELECT * FROM `patients` WHERE `Email` = '"+email+
				"' AND `Password` = '"+password+"';";
		boolean loggedIn = false;
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			loggedIn = rs.next();
			if (loggedIn) {
				p = new Patient();
				p.setID(rs.getInt("ID"));
				p.setFirstName(rs.getString("FirstName"));
				p.setLastName(rs.getString("LastName"));
				p.setEmail(rs.getString("Email"));
				p.setPhoneNumber(rs.getString("PhoneNumber"));
				p.setPassword(rs.getString("Password"));
				p.setBloodGroup(rs.getString("BloodGroup"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loggedIn;
	}
	
	public Patient getPatient() {
		return p;
	}

}
