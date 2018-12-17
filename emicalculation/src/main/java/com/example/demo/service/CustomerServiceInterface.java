package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;

import com.example.demo.model.Input;
import com.example.demo.model.Output;

public interface CustomerServiceInterface {
	
public void method(Input input);
 
public List<Output> calc(Model model);
 
public void printer(int id,Model  model);

 }
