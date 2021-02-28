package webApp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webApp.demo.dao.AppointmentDao;
import webApp.demo.entity.Appointment;


@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentDao AppointmentDao;
	
	
	@Transactional
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return AppointmentDao.getAppointments();
	}

	
	@Transactional
	public void saveAppointment(Appointment theAppointment) {
		// TODO Auto-generated method stub
		AppointmentDao.saveAppointment(theAppointment);
	}

	
	@Transactional
	public Appointment getAppointment(int theId) {
		// TODO Auto-generated method stub
		return AppointmentDao.getAppointment(theId);
	}

	
	@Transactional
	public void deleteAppointment(int theId) {
		// TODO Auto-generated method stub
		
		AppointmentDao.deleteAppointment(theId);
		
	}

	
	@Transactional
	public List<Appointment> searchAppointments(String theSearchName) {
		// TODO Auto-generated method stub
		return AppointmentDao.searchAppointments(theSearchName);
		
	}
	


}

