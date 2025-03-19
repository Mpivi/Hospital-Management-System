package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Patient;

public class CreatePatient {
	
	private Patient p;
	private Database database;
	
	public CreatePatient(Patient p, Database database) {
		this.p = p;
		this.database = database;
	}
	
	public boolean isCreated() {
		boolean created = false;
		String insert = "INSERT INTO `patients`(`FirstName`, `LastName`, `Email`,"
				+ " `PhoneNumber`, `Password`, `BloodGroup`) VALUES ('"+
				p.getFirstName()+"','"+p.getLastName()+"','"+p.getEmail()+"','"+
				p.getPhoneNumber()+"','"+p.getPassword()+"','"+p.getBloodGroup()
				+"');";
		try {
			database.getStatement().execute(insert);
			created = true;
		} catch (SQLException e) {
			e.printStackTrace();
			created = false;
		}
		return created;
	}

}
