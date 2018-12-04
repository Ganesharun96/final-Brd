/*
 * class:EmiCalculator
 * Version:calc v.0.1
 * Author:Ganesh
 * 
 */

package com.brd.brd1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmiCalculator {

	public static void main(String[] args) {

		 EmiCalculator calc = new  EmiCalculator();
		calc.getInstallments();

	}

	public float calculateEMI(float loanAmount, float rateOfInterest, float tenure, float numberOfInstallments) {

	
		float num = ((rateOfInterest / 100) / numberOfInstallments);
		float num1 = loanAmount * ((rateOfInterest / 100) / numberOfInstallments);
		float denom = 1 + num;
		float denom1 = (float) Math.pow(denom, tenure);
		float denom2 = (1 - (1 / denom1));
		float installmentAmount = num1 / denom2;
		return (float) installmentAmount;

	}

	float repaymentSchedule(int i1, float loanAmount, float rateOfInterest, float tenure, float numberOfInstallments,
			float installmentAmount) {

		DecimalFormat formatter = new DecimalFormat("0.00");
		float num1 = loanAmount * ((rateOfInterest / 100) / numberOfInstallments);
		float principle = installmentAmount - num1;
		float outstandingPrinciple = loanAmount - principle;

		System.out.println(i1 + "  " + formatter.format(loanAmount) + "     " + formatter.format(num1) + "  "
				+ formatter.format(principle) + "  " + formatter.format(installmentAmount));

		System.out.println();
		return outstandingPrinciple;
		

	}

	float getInstallmentNo(float loanAmount, float rateOfInterest, float tenure, float numberOfInstallments,
			float installmentAmount, int insNo, int iteration) {

		DecimalFormat formatter = new DecimalFormat("0.00");

		float num1 = loanAmount * ((rateOfInterest / 100) / numberOfInstallments);
		float principle = installmentAmount - num1;
		float outstandingPrinciple = loanAmount - principle;

		if (insNo == iteration + 1) {
			System.out.println((iteration + 1) + "  " + formatter.format(loanAmount) + "     " + formatter.format(num1) + "  "
					+ formatter.format(principle) + "  " + formatter.format(installmentAmount));

		}
		return outstandingPrinciple;
	}
public void getInstallments() {

		Scanner sc = new Scanner(System.in);
		System.out.println("loan Amount");
		float loanAmount = sc.nextFloat();
		System.out.println("Rate_of_Interest");
		float rateOfInterest = sc.nextFloat();
	
		float tenure = 0;
		try {
			System.out.println("value of tenure");
			tenure = sc.nextFloat();
			if (tenure < 0) {
				throw new InputMismatchException("negative number");
			}
		}

		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			while (tenure < 0) {
				System.out.println("enter positive no");
				tenure = sc.nextFloat();
			}
		}
		float numberofInstallments = 0;
		try {
			System.out.println("Number_of_Installments");
			numberofInstallments = sc.nextFloat();
			if (numberofInstallments >tenure) {
				throw new InputMismatchException("incorrect number");
			}
		}

		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			while(numberofInstallments >tenure){
				System.out.println("enter correct  no of insta");
				numberofInstallments = sc.nextFloat();
			}
		}


		float emi = calculateEMI(loanAmount, rateOfInterest, tenure, numberofInstallments);
		System.out.println("sno loanamount interst principle emi");
		//		System.out.println("sno loanamt inr principle emi");

		float loanAmount1 = loanAmount;
		for (int i1 = 1; i1 <= 12; i1++) {
			loanAmount = (float) repaymentSchedule(i1, loanAmount, rateOfInterest, tenure, numberofInstallments,
					emi);
		}
		System.out.println("instno");

		int insNo = sc.nextInt();
		System.out.println("sno loanamount interst principle emi");
//		System.out.println("sno loanamt inr principle emi");
		for (int i1 = 0; i1 <= 12; i1++) {

			loanAmount1 = (float) getInstallmentNo(loanAmount1, rateOfInterest, tenure, numberofInstallments, emi,
					insNo, i1);
		}
	}
}