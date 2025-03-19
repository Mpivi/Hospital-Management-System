package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Doctor;
import Model.Operation;

public class ReadDoctorOperations {
	
	private ArrayList<Operation> operations;
	
	public ReadDoctorOperations(Doctor d, Database database) {
		String select = "SELECT * FROM `operations` WHERE `Doctor` = "+
				d.getID()+" ;";
		operations = new ArrayList<>();
		ArrayList<Integer> patientsIDs = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Operation o = new Operation();
				o.setID(rs.getInt("ID"));
				o.setDoctor(d);
				o.setDateTime(rs.getString("DateTime"));
				patientsIDs.add(rs.getInt("Patient"));
				o.setPaid(Boolean.parseBoolean(rs.getString("Paid")));
				o.setDiagnosis(rs.getString("Diagnosis"));
				operations.add(o);
			}
			for (int i=0;i<operations.size();i++) {
				operations.get(i).setPatient(new ReadPatient(
						patientsIDs.get(i), database).getPatient());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Operation> getOperations() {
		return operations;
	}

}
