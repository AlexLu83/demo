package webApp.demo.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webApp.demo.entity.Doctor;


@Repository
public class DoctorDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Doctor> theQuery = currentSession.createQuery("from Doctor order by last_name ", Doctor.class);
		
		List<Doctor> Doctors = theQuery.getResultList();
		
		return Doctors;
	} 


	public void saveDoctor(Doctor theDoctor) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theDoctor);
	}


	public Doctor getDoctor(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Doctor.class, theId);
	}


	public void deleteDoctor(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Doctor where id=:theDoctorId").setParameter("theDoctorId", theId);
		theQuery.executeUpdate();
		
		
	}


	public List<Doctor> searchDoctors(String theSearchName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Doctor> theQuery = null;
		 if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Doctor where lower(firstName) like :theName or lower(lastName) like :theName", Doctor.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all Doctors
	            theQuery =currentSession.createQuery("from Doctor order by last_name", Doctor.class);            
	        }
		List<Doctor> Doctors = theQuery.getResultList();
	
		return Doctors;
		
	}
	
	
	
	

}


