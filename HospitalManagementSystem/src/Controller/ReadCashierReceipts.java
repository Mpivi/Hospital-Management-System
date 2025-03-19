package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cashier;
import Model.Database;
import Model.Receipt;

public class ReadCashierReceipts {
	
	private ArrayList<Receipt> receipts;
	
	public ReadCashierReceipts(Cashier c, Database database) {
		String select = "SELECT * FROM `receipts` WHERE `Cashier` = "+c.getID()+" ;";
		receipts = new ArrayList<>();
		ArrayList<Integer> patientsIDs = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Receipt r = new Receipt();
				r.setID(rs.getInt("ID"));
				patientsIDs.add(rs.getInt("Patient"));
				r.setCashier(c);
				r.setAmount(rs.getDouble("Amount"));
				r.setType(rs.getInt("Type"));
				r.setItemID(rs.getInt("ItemID"));
				receipts.add(r);
			}
			for (int i=0;i<receipts.size();i++) {
				receipts.get(i).setPatient(new ReadPatient(
						patientsIDs.get(i), database).getPatient());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

}
