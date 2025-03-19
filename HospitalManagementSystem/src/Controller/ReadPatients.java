package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Patient;

public class ReadPatients {
	
	private ArrayList<Patient> patients;
	
	public ReadPatients(Database database) {
		String select = "SELECT * FROM `patients`;";
		patients = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Patient p = new Patient();
				p.setID(rs.getInt("ID"));
				p.setFirstName(rs.getString("FirstName"));
				p.setLastName(rs.getString("LastName"));
				p.setEmail(rs.getString("Email"));
				p.setPhoneNumber(rs.getString("PhoneNumber"));
				p.setPassword(rs.getString("Password"));
				p.setBloodGroup(rs.getString("BloodGroup"));
				patients.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}

}
