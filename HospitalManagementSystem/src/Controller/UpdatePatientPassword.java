package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Patient;

public class UpdatePatientPassword {
	
	private Patient p;
	private Database database;
	
	public UpdatePatientPassword(Patient p, Database database) {
		this.p = p;
		this.database = database;
	}
	
	public boolean isUpdated() {
		boolean updated = false;
		String update = "UPDATE `patients` SET `Password`='"+p.getPassword()
			+"' WHERE `ID` = "+p.getID()+" ;";
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
