
package com.example.demo.model;



public class Input{
	private float loanAmount;
	private float rateOfInterest;
	private float tenure;
	private float numberofInstallments;
	public float getLoanAmount() {
		return loanAmount;
		}
	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public float getTenure() {
		return tenure;
	}
	public void setTenure(float tenure) {
		this.tenure = tenure;
	}
	public float getNumberofInstallments() {
		return numberofInstallments;
	}
	public void setNumberofInstallments(float numberofInstallments) {
		this.numberofInstallments = numberofInstallments;
	}
	
}