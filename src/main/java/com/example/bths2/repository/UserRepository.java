package com.example.bths2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bths2.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
