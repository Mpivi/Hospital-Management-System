package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.User;

public class UpdateEmployeePassword {
	
	private User e;
	private Database database;
	
	public UpdateEmployeePassword(User e, Database database) {
		this.e = e;
		this.database = database;
	}
	
	public boolean isUpdated() {
		boolean updated = false;
		String update = "UPDATE `employees` SET `Password`='"+e.getPassword()+
				"' WHERE `ID` = "+e.getID()+" ;";
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
