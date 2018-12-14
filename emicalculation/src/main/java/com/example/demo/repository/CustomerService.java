package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Input;

public interface CustomerService extends  JpaRepository<Input, Float> {

}


