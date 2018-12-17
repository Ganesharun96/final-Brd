package com.example.demo.service;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.model.Input;
import com.example.demo.model.Output;
import com.example.demo.repository.CustomerRepository;

@Service
public class Calculation implements CustomerServiceInterface {
	@Autowired
	private CustomerRepository customerrepo;

	static float installmentAmount = (float) 0;
	static boolean installmentAmountFlag = true;
   
	@Override
	public void method(Input input) {
		float loanAmount = input.getLoanAmount();
		float rateOfInterest = input.getRateOfInterest();
		float tenure = input.getTenure();
		float numberofInstallments = input.getNumberofInstallments();
		for (int i1 = 1; i1 <= numberofInstallments; i1++) {

			loanAmount = calculateEMI(i1, loanAmount, rateOfInterest, tenure, numberofInstallments);
		}

	}

	public float calculateEMI(int value, float loanAmount, float rateOfInterest, float tenure,
			float numberOfInstallments) {

		float num = ((rateOfInterest / 100) / numberOfInstallments);
		float num1 = loanAmount * num;
		float denom = 1 + num;
		float denom1 = (float) Math.pow(denom, tenure);
		float denom2 = (1 - (1 / denom1));
		
	if (installmentAmountFlag) {

			 installmentAmount = num1 / denom2;
			installmentAmountFlag = false;

		}

		float principle = installmentAmount - num1;
		float outstandingPrinciple = loanAmount - principle;

		DecimalFormat formatter = new DecimalFormat("0.00");

		Float outstandingPrinciple1 = Float.parseFloat(formatter.format(loanAmount));
		Float interest = Float.parseFloat(formatter.format(num1));
		Float loanAmount1 = Float.parseFloat(formatter.format(principle));

		Output output = new Output();
		output.setPrincipals(loanAmount1);

		output.setInterst(interest);

		output.setEmi(Calculation.installmentAmount);

		output.setOutsandingPrincipals(outstandingPrinciple1);
		output.setValue(value);

		customerrepo.save(output);

		System.out.println(formatter.format(value) + "  " + formatter.format(loanAmount) + "     " + formatter.format(num1)
						+ "  " + formatter.format(principle) + "  " + formatter.format(installmentAmount));
		

		return outstandingPrinciple;

	}

	@Override
	public List<Output> calc(Model model) {
		model.addAttribute("outputs",customerrepo.findAll());
		return customerrepo.findAll();
	}

	@Override
	public void printer(int id,Model model) {
		model.addAttribute("put",customerrepo.findById(id).get());
		
	}
}






