package webApp.demo.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webApp.demo.entity.Appointment;


@Repository
public class AppointmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Appointment> theQuery = currentSession.createQuery("from Appointment order by id ", Appointment.class);
		
		List<Appointment> Appointments = theQuery.getResultList();
		
		return Appointments;
	} 


	public void saveAppointment(Appointment theAppointment) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theAppointment);
	}


	public Appointment getAppointment(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Appointment.class, theId);
	}


	public void deleteAppointment(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Appointment where id=:theAppointmentId").setParameter("theAppointmentId", theId);
		theQuery.executeUpdate();
		
		
	}


	public List<Appointment> searchAppointments(String theSearchName) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Appointment> theQuery = null;
		       
	        
		List<Appointment> Appointments = theQuery.getResultList();
	
		return Appointments;
		
	}
	
	
	
	

}


