package Model;

import View.ChangePatientPassword;
import View.ViewPatientPaidOperations;
import View.ViewPatientPaidReports;
import View.ViewPatientUnpaidOperations;
import View.ViewPatientUnpaidReports;
import View.ViewPatientUserData;
import View.ViewPatientUserOperations;
import View.ViewPatientUserReports;
import View.ViewUserReceipts;

public class Patient extends User {
	
	private String bloodGroup;
	
	public Patient() {
		super();
		this.options = new Option[] {
				new ViewPatientUserData(),
				new ViewPatientUserOperations(),
				new ViewPatientUserReports(),
				new ViewPatientUnpaidOperations(),
				new ViewPatientUnpaidReports(),
				new ViewPatientPaidOperations(),
				new ViewPatientPaidReports(),
				new ViewUserReceipts(),
				new ChangePatientPassword()
		};
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

}
