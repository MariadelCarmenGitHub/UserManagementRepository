package com.practices.usermanagementbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practices.usermanagementbackend.model.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer>{
    
}
