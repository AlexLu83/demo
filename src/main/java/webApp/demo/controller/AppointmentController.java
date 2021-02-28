package webApp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webApp.demo.entity.Appointment;
import webApp.demo.entity.Doctor;
import webApp.demo.service.AppointmentService;
import webApp.demo.service.DoctorService;


@Controller
@RequestMapping("/Appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService AppointmentService;

	@GetMapping("/list")
	public String listAppointments(Model theModel) {
		
		List<Appointment> theAppointments = AppointmentService.getAppointments();
		
		theModel.addAttribute("Appointments", theAppointments);
;		
		return "list-Appointments";
	}
	
	@GetMapping("/listDoctors")
	public String listDoctors(Model theModel) {
		
		List<Doctor> theDoctors = DoctorService.getDoctors();
		
		theModel.addAttribute("Doctors", theDoctors);
;		
		return "list-Doctors";
	}
	
	@GetMapping("/AddAppointment")
	public String showFromForAdd(Model theModel) {
		Appointment theAppointment = new Appointment();
		
		theModel.addAttribute("Appointment", theAppointment);
		
		
		return "Appointment-form";
	}
	
	@PostMapping("/saveAppointment")
	public String saveAppointment(@ModelAttribute("Appointment") Appointment theAppointment) {
		
		AppointmentService.saveAppointment(theAppointment);
		return "redirect:/Appointment/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("AppointmentId") int theId, Model theModel) {
		Appointment theAppointment = AppointmentService.getAppointment(theId);
		
		theModel.addAttribute("Appointment", theAppointment);
		
		return "Appointment-form";
		
		
	}
	
	@GetMapping("/delete")
	public String deleteAppointment(@RequestParam("AppointmentId") int theId) {
		
		AppointmentService.deleteAppointment(theId);
		
		return "redirect:/Appointment/list";
		
	}
	
}



