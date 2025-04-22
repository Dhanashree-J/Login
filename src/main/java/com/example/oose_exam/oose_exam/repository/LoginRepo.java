package com.example.oose_exam.oose_exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oose_exam.oose_exam.domain.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login,String> {
    Login findByUsernameAndPassword(String username,String password);
}
