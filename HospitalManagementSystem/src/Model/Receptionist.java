package Model;

import View.AddNewEmployee;
import View.AddNewPatient;
import View.ChangePassword;
import View.EditEmployee;
import View.EditPatient;
import View.FireEmployee;
import View.RemovePatient;
import View.ViewAllPatients;
import View.ViewEmployees;

public class Receptionist extends Employee {
	
	public Receptionist() {
		super();
		this.options = new Option[] {
				new AddNewEmployee(),
				new ViewEmployees(),
				new EditEmployee(),
				new FireEmployee(),
				new AddNewPatient(),
				new ViewAllPatients(),
				new EditPatient(),
				new RemovePatient(),
				new ChangePassword()
		};
	}

	@Override
	public int getJob() {
		return 2;
	}

	@Override
	public String getJobToString() {
		return "Receptionist";
	}

}
