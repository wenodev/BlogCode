package com.example.simsim.api;

import com.example.simsim.entity.Customer;
import com.example.simsim.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class AuthController {

    private final CustomerService customerService;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody Customer customer){
        customerService.signUp(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
