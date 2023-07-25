package com.example.GSravanthi_Capstone.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.GSravanthi_Capstone.model.appointment;
import com.example.GSravanthi_Capstone.service.appointmentService;



@Controller
@RequestMapping("/patients")
public class patientController {
	@Autowired
	private appointmentService service;

	@GetMapping("/myAppointments")
	public String myAppointments(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String patientName = authentication.getName();
		List<appointment> listAppointments = service.findByPatientName(patientName);
		model.addAttribute("listAppointments",listAppointments);
		return "myAppointments";
	}
	
	@GetMapping("/cancelAppointment")
	public String cancelAppointment(Model model) {
		appointment cancelAppointment = new appointment();
		model.addAttribute("appointment",cancelAppointment);
		return "cancelAppointment";
	
	}
	
}
