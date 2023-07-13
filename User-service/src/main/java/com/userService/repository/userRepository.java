package com.userService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userService.Entity.User;

@Repository
public interface userRepository extends JpaRepository<User, Integer>{

}
