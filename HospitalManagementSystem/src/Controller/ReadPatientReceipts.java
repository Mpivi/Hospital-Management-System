package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cashier;
import Model.Database;
import Model.Patient;
import Model.Receipt;

public class ReadPatientReceipts {
	
	private ArrayList<Receipt> receipts;
	
	public ReadPatientReceipts(Patient p, Database database) {
		String select = "SELECT * FROM `receipts` WHERE `Patient` = "+p.getID()+" ;";
		receipts = new ArrayList<>();
		ArrayList<Integer> cashiersIDs = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Receipt r = new Receipt();
				r.setID(rs.getInt("ID"));
				r.setPatient(p);
				cashiersIDs.add(rs.getInt("Cashier"));
				r.setAmount(rs.getDouble("Amount"));
				r.setType(rs.getInt("Type"));
				r.setItemID(rs.getInt("ItemID"));
				receipts.add(r);
			}
			for (int i=0;i<receipts.size();i++) {
				receipts.get(i).setCashier((Cashier) new ReadEmployee(
						cashiersIDs.get(i), database).getEmployee());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

}
