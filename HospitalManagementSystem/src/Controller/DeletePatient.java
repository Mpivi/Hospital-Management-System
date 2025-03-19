package Controller;

import java.sql.SQLException;

import Model.Database;

public class DeletePatient {
	
	private int ID;
	private Database database;
	
	public DeletePatient(int ID, Database database) {
		this.ID = ID;
		this.database = database;
	}
	
	public boolean isDeleted() {
		boolean deleted = false;
		String delete = "DELETE FROM `patients` WHERE `ID` = "+ID+" ;";
		try {
			database.getStatement().execute(delete);
			deleted = true;
		} catch (SQLException e) {
			e.printStackTrace();
			deleted = false;
		}
		return deleted;
	}

}
