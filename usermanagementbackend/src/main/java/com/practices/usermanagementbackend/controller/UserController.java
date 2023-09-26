package com.practices.usermanagementbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practices.usermanagementbackend.model.Users;
import com.practices.usermanagementbackend.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * Get All Users
     * @return The list of all users in the system
     */
    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }

    /**
     * Get user by identifier
     * @param id, The user identifier 
     * @return The user with the identifier indicated by parameter
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    /**
     * Add user
     * @param The new user
     * @return The new user added in the system
     */
    @PostMapping("/users")
    public ResponseEntity<Users> addUser(@RequestBody Users user){        
        return ResponseEntity.ok(this.userService.addUser(user));
    }

    /**
     * Update user
     * @param id, the user identifier
     * @param user, the new details user to update
     * @return the updated user
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Integer id, @RequestBody Users userDetails){       
        return ResponseEntity.ok(this.userService.updateUser(id, userDetails));
    }

    /**
     * Deleted user
     * @param id, the user identifier 
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.userService.deleteUser(id);
    } 
}