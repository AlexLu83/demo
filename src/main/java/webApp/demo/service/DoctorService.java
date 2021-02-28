package webApp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webApp.demo.dao.DoctorDao;
import webApp.demo.entity.Doctor;


@Service
public class DoctorService {
	
	@Autowired
	private DoctorDao DoctorDAO;
	
	
	@Transactional
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return DoctorDAO.getDoctors();
	}

	
	@Transactional
	public void saveDoctor(Doctor theDoctor) {
		// TODO Auto-generated method stub
		DoctorDAO.saveDoctor(theDoctor);
	}

	
	@Transactional
	public Doctor getDoctor(int theId) {
		// TODO Auto-generated method stub
		return DoctorDAO.getDoctor(theId);
	}

	
	@Transactional
	public void deleteDoctor(int theId) {
		// TODO Auto-generated method stub
		
		DoctorDAO.deleteDoctor(theId);
		
	}

	
	@Transactional
	public List<Doctor> searchDoctors(String theSearchName) {
		// TODO Auto-generated method stub
		return DoctorDAO.searchDoctors(theSearchName);
		
	}
	


}

