package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation {
	
	private int ID;
	private Doctor doctor;
	private Patient patient;
	private LocalDateTime dateTime;
	private boolean paid;
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm:ss");
	private String diagnosis;
	
	public Operation() {
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String getDateTime() {
		return dateTimeFormatter.format(dateTime);
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
	}
	
	public String getDateTimeFormat() {
		return "MM/dd/yyyy-HH:mm:ss";
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

}
