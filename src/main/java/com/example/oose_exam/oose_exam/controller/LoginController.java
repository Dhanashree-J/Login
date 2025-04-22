package com.example.oose_exam.oose_exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.oose_exam.oose_exam.domain.Login;
import com.example.oose_exam.oose_exam.repository.LoginRepo;
import com.example.oose_exam.oose_exam.service.LoginService;



@Controller
public class LoginController {
    
    @Autowired
    private LoginRepo repo;

    @Autowired 
    private LoginService service;


    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String validateuser(@RequestParam String username,@RequestParam String password,Model model) {
        //TODO: process POST request
        Login user=new Login();
        user=service.log(username,password);
        if(user!=null)
        {
            return "welcome";
        }
        else{
            model.addAttribute("error","Invalid Credentials!!");
        }
        return "login";
    }
    
    @GetMapping("/login")
    public String showUserLoginPage() {
        return "login";
    }
    
    @GetMapping("/register")
    public String showNewuserPage(Model model){
        model.addAttribute("user",new Login());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Login login) {
        //TODO: process POST request
        repo.save(login);
        return "redirect:/login";
    }
    
    
}
