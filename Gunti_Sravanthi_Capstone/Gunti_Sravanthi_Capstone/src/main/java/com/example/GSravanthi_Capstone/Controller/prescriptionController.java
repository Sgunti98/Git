package com.example.GSravanthi_Capstone.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.GSravanthi_Capstone.model.prescription;
import com.example.GSravanthi_Capstone.service.appointmentService;
import com.example.GSravanthi_Capstone.service.prescriptionService;

@Controller
public class prescriptionController {
	@Autowired
	private prescriptionService service;
	
	@Autowired
	private appointmentService service1;
	
	@GetMapping("/viewPrescriptions")
	public String viewPrescription(Model model) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String patientName = authentication.getName();
		List<prescription> prescriptions = service.findByPatientName(patientName);
		model.addAttribute("prescriptions",prescriptions);
		return"viewPrescriptions";
	}
	
	@GetMapping("/savePrescription")
	public String saveProduct(@ModelAttribute("prescription") prescription prescription,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes
			) {
		Integer id= prescription.getAppointmentID();
		service1.setPrescription("prescribed", id);
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String doctorName = auth.getName();
		prescription.setDoctorName(doctorName);
	   service.save(prescription);
	   String message = "Prescription was successfully saved ";
	   redirectAttributes.addFlashAttribute("message", message);
	   redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	   return "redirect:/doctorAppointments";
}
}
