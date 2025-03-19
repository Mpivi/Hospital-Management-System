package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Report;

public class CreateReport {
	
	private Report r;
	private Database database;
	
	public CreateReport(Report r, Database database) {
		this.r = r;
		this.database = database;
	}
	
	public boolean isCreated() {
		boolean created = false;
		String insert = "INSERT INTO `reports`(`Doctor`, `Patient`, `DateTime`,"
				+ " `Diagnosis`, `Treatment`, `Paid`) VALUES ('"+
				r.getDoctor().getID()+"','"+r.getPatient().getID()+"','"+
				r.getDateTime()+"','"+r.getDiagnosis()+"','"+r.getTreatment()+"','"
				+r.isPaid()+"');";
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
