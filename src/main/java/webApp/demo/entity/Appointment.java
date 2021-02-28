package webApp.demo.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="start_time")
	private int start_time;
	
	@Column(name="end_time")
	private int end_time;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Doctor getDoctor()
	{
		return doctor;
	}
	public Appointment() {
		
	}
	public Appointment(int start_time, int end_time) {
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", start_time=" + start_time + ", end_time=" + end_time + ", doctor=" + doctor
				+ "]";
	}
	
	
	
}
