package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Operation;

public class CreateOperation {
	
	private Operation o;
	private Database database;
	
	public CreateOperation(Operation o, Database database) {
		this.o = o;
		this.database = database;
	}
	
	public boolean isCreated() {
		boolean created = false;
		String insert = "INSERT INTO `operations`(`Doctor`, `Patient`, `DateTime`,"
				+ " `Paid`, `Diagnosis`) VALUES ('"+o.getDoctor().getID()+
				"','"+o.getPatient().getID()+"','"+o.getDateTime()+"','"+o.isPaid()
				+"','"+o.getDiagnosis()+"');";
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
