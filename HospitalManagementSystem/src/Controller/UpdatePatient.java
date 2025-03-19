package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Patient;

public class UpdatePatient {
	
	private Patient p;
	private Database database;
	
	public UpdatePatient(Patient p, Database database) {
		this.p = p;
		this.database = database;
	}
	
	public boolean isUpdated() {
		boolean updated = false;
		String update = "UPDATE `patients` SET `FirstName`='"+p.getFirstName()
		+"',`LastName`='"+p.getLastName()+"',`Email`='"+p.getEmail()+"',"
				+ "`PhoneNumber`='"+p.getPhoneNumber()+"',`BloodGroup`='"+
		p.getBloodGroup()+"' WHERE `ID` = "+p.getID()+" ;";
		try {
			database.getStatement().execute(update);
			updated = true;
		} catch (SQLException e) {
			e.printStackTrace();
			updated = false;
		}
		return updated;
	}

}
