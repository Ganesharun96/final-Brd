package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.Input;
import com.example.demo.model.Output;
import com.example.demo.service.Calculation;



@Controller
public class EmiController {
	@Autowired
	private Calculation calculation;
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
 	public String read(Model model)

	{
		//Calculation cal = new Calculation(loanAmount1, rateOfInterest, tenure, numberofInstallments);
		model.addAttribute("user", new Input());
		return "User";
				
	}
	@RequestMapping(value="/show", method= RequestMethod.POST)
public String print(@ModelAttribute("user")Input input,Model model)	{
		
		
calculation.method(input);
calculation.calc(model);
	
	return "Display";
		
	}
	@RequestMapping(value="/sh", method =  RequestMethod.POST)
	public String printful(@RequestParam("id")int theid, Model model)
	{	
		calculation.printer(theid,model);
        return "Page";
	}
	
	
}
