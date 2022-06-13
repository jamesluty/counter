package com.jamesluty.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);			
		}
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer counter = (Integer) session.getAttribute("count");
		model.addAttribute("counter", counter);
		session.setAttribute("count", counter + 1);
//		System.out.println(session.getAttribute("count"));
		return "counter.jsp";
	}
	
	@GetMapping("/counter/2")
	public String counter2(HttpSession session, Model model) {
		Integer counter = (Integer) session.getAttribute("count");
		model.addAttribute("counter", counter);
		session.setAttribute("count", counter + 2);
//		System.out.println(session.getAttribute("count"));
		return "counter2.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 1);
		return "index.jsp";
	}
}
