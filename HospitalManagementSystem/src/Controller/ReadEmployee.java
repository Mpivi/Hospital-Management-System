package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Cashier;
import Model.Database;
import Model.Doctor;
import Model.Employee;
import Model.Receptionist;

public class ReadEmployee {
	
	private Employee e;
	
	public ReadEmployee(int ID, Database database) {
		String select = "SELECT * FROM `employees` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			int job = rs.getInt("Job");
			switch (job) {
			case 0:
				e = new Doctor();
				((Doctor) e).setSpecialization(rs.getString("Specialization"));
				break;
			case 1:
				e = new Cashier();
				break;
			case 2:
				e = new Receptionist();
				break;
				default:
					e = new Employee() {
						@Override
						public int getJob() {
							return -1;
						}
						@Override
						public String getJobToString() {
							return "Unknown job";
						}
					};
			}
			e.setID(rs.getInt("ID"));
			e.setFirstName(rs.getString("FirstName"));
			e.setLastName(rs.getString("LastName"));
			e.setEmail(rs.getString("Email"));
			e.setPhoneNumber(rs.getString("PhoneNumber"));
			e.setPassword(rs.getString("Password"));
			e.setSalary(rs.getDouble("Salary"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee getEmployee() {
		return e;
	}

}
