package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Output {
	
	private int value;
	private int id;
	private float outsandingPrincipals;
	private float interst;
	private float principals;
	private float emi ;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getOutsandingPrincipals() {
		return outsandingPrincipals;
	}
	public void setOutsandingPrincipals(float outsandingPrincipals) {
		this.outsandingPrincipals = outsandingPrincipals;
	}
	public float getInterst() {
		return interst;
	}
	public void setInterst(float interst) {
		this.interst = interst;
	}
	public float getPrincipals() {
		return principals;
	}
	public void setPrincipals(float principals) {
		this.principals = principals;
	}
	public float getEmi() {
		return emi;
	}
	public void setEmi(float emi) {
		this.emi = emi;
	}
	
	
}

