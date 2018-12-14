package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.Input;
import com.example.demo.repository.CustomerService;
import com.example.demo.service.Calculation;



@Controller
public class EmiController {
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
 	public String read(Model model)

	{
		//Calculation cal = new Calculation(loanAmount1, rateOfInterest, tenure, numberofInstallments);
		model.addAttribute("user", new Input());
		return "User";
				
	}
	@RequestMapping(value="/show", method= RequestMethod.POST)
public String print(@RequestParam("loanAmount")float loanAmount,@RequestParam("rateOfInterest")float rateOfInterest,@RequestParam("tenure")float tenure,@RequestParam("numberofInstallments")float numberofInstallments)	{
	
		
		
		{
		Calculation cal = new Calculation(loanAmount, rateOfInterest, tenure, numberofInstallments);
		return "Display";
		}
		
		
		
		
	}
}
