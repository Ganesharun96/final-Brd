package com.example.demo.service;



import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculation {
	
	float loanAmount1;
	float rateOfInterest;
	float tenure;
	public Calculation(float loanAmount1, float rateOfInterest, float tenure, float numberofInstallments) {
		super();
		this.loanAmount1 = loanAmount1;
		this.rateOfInterest = rateOfInterest;
		this.tenure = tenure;
		this.numberofInstallments = numberofInstallments;
	}

	float numberofInstallments;
	
	
	public void getInstallments() {

		
	for (int i1 = 0; i1 <= 12; i1++) {

			loanAmount1 =  repaymentSchedule(i1, loanAmount1, rateOfInterest, tenure, numberofInstallments);
		}
	}
	
	
	

	public float calculateEMI(float loanAmount, float rateOfInterest, float tenure, float numberOfInstallments) {

	
		float num = ((rateOfInterest / 100) / numberOfInstallments);
		float num1 = loanAmount * ((rateOfInterest / 100) / numberOfInstallments);
		float denom = 1 + num;
		float denom1 = (float) Math.pow(denom, tenure);
		float denom2 = (1 - (1 / denom1));
		float installmentAmount = num1 / denom2;
		
		float principle = installmentAmount - num1;
		float outstandingPrinciple = loanAmount - principle;
//		return (float) installmentAmount;
		return outstandingPrinciple;

	}

	float repaymentSchedule(int i1, float loanAmount, float rateOfInterest, float tenure, float numberOfInstallments) {
		
		 float installmentAmount =calculateEMI( loanAmount,  rateOfInterest,  tenure,  numberOfInstallments);
		 
		DecimalFormat formatter = new DecimalFormat("0.00");
		float num1 = loanAmount * ((rateOfInterest / 100) / numberOfInstallments);
		float principle = installmentAmount - num1;
		float outstandingPrinciple = loanAmount - principle;

		System.out.println(i1 + "  " + formatter.format(loanAmount) + "     " + formatter.format(num1) + "  "
				+ formatter.format(principle) + "  " + formatter.format(installmentAmount));

		System.out.println();
		return outstandingPrinciple;
		

	}


}