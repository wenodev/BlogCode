package com.example.simsim.service;

import com.example.simsim.entity.Customer;
import com.example.simsim.entity.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void signUp(Customer customer){
        customerRepository.save(customer);
    }



}
