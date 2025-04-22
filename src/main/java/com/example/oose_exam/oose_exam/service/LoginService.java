package com.example.oose_exam.oose_exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oose_exam.oose_exam.domain.Login;
import com.example.oose_exam.oose_exam.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    private LoginRepo repo;

    public Login log(String username,String password)
    {
        Login user=repo.findByUsernameAndPassword(username,password);
        return user;
    }
}
