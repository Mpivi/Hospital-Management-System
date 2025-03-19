package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cashier;
import Model.Database;
import Model.Doctor;
import Model.Employee;
import Model.Receptionist;

public class ReadEmployees {
	
	private ArrayList<Employee> employees;
	
	public ReadEmployees(Database database) {
		String select = "SELECT * FROM `employees`;";
		employees = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Employee e;
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
				employees.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

}
