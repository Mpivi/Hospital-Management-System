package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Receipt;

public class CreateReceipt {
	
	private Receipt r;
	private Database database;
	
	public CreateReceipt(Receipt r, Database database) {
		this.r = r;
		this.database = database;
	}
	
	public boolean isCreated() {
		boolean created = false;
		String update = "";
		if (r.getType()==0) {
			//Operation
			update = "UPDATE `operations` SET `Paid`='true' WHERE `ID` = "+
				r.getItemID()+" ;";
		} else if (r.getType()==1) {
			//Report
			update = "UPDATE `reports` SET `Paid`='true' WHERE `ID` = "+
				r.getItemID()+" ;";
		}
		String insert = "INSERT INTO `receipts`(`Cashier`, `Patient`, `Amount`,"
				+ " `Type`, `ItemID`) VALUES ('"+r.getCashier().getID()+"','"+
				r.getPatient().getID()+"','"+r.getAmount()+"','"+r.getType()+"','"
				+r.getItemID()+"');";
		try {
			database.getStatement().execute(insert);
			database.getStatement().execute(update);
			created = true;
		} catch (SQLException e) {
			e.printStackTrace();
			created = false;
		}
		return created;
	}

}
