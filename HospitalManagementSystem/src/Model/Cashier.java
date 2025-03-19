package Model;

import View.AddNewReceipt;
import View.ChangePassword;
import View.ViewAllReceipts;
import View.ViewCashierReceipts;
import View.ViewPatientReceipts;

public class Cashier extends Employee {
	
	public Cashier() {
		super();
		this.options = new Option[] {
				new AddNewReceipt(),
				new ViewAllReceipts(),
				new ViewCashierReceipts(),
				new ViewPatientReceipts(),
				new ChangePassword()
		};
	}

	@Override
	public int getJob() {
		return 1;
	}

	@Override
	public String getJobToString() {
		return "Cashier";
	}

}
