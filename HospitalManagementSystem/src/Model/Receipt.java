package Model;

public class Receipt {
	
	private int ID;
	private Cashier cashier;
	private Patient patient;
	private double amount;
	private int type;
	// 0 ==> Operation
	// 1 ==> Report
	private int itemID; //Operation/Report ID
	
	public Receipt() {
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public Cashier getCashier() {
		return cashier;
	}
	
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getTypeToString() {
		if (type==0) {
			return "Operation";
		} else if (type==1) {
			return "Report";
		} else {
			return null;
		}
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

}
