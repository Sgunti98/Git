package com.example.GSravanthi_Capstone.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.GSravanthi_Capstone.Repository.EventJRepository;
import com.example.GSravanthi_Capstone.model.event;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalenderApplication {
	@Autowired
	private EventJRepository eventRepository; 
	
//	@RequestMapping(value="/", method=RequestMethod.GET) 
//	public ModelAndView index() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping(value="/staticcalendar", method=RequestMethod.GET) 
	public ModelAndView staticcalendar() {
		return new ModelAndView("staticcalendar");
	}
	
	@RequestMapping(value="/calendar", method=RequestMethod.GET) 
	public ModelAndView calendar() {
		return new ModelAndView("calendar");
	}
	
	@RequestMapping(value="/jsoncalendar", method=RequestMethod.GET) 
	public ModelAndView jsoncalendar() {
		return new ModelAndView("jsoncalendar");
	}
	
	@RequestMapping(value="/eventlist", method=RequestMethod.GET) 
	public String events(HttpServletRequest request, Model model) {
		List<event> event = eventRepository.findAll();
		model.addAttribute("events",event);
		return "allevents";
	}

}
