package com.greatlearning.G2AB4_BED_GradedProject3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String showMainPage() {
		return "mainpage";
	}
}
