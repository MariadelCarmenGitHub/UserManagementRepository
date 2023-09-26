package com.practices.usermanagementbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practices.usermanagementbackend.exceptions.ResourceNotFoundException;
import com.practices.usermanagementbackend.model.Users;
import com.practices.usermanagementbackend.repository.IUsersRepository;

@Component
public class UserServiceImpl implements UserService{

     @Autowired
    private IUsersRepository userRepository;

    /**
     * Get all users
     * @return List of all users
     */
    @Override
    public List<Users> getAllUsers(){
        return this.userRepository.findAll();
    }

      /***
     * Get User By Identifier
     * @param id, the user identifier
     * @return The User found
     */
    @Override
    public Users getUserById(Integer id){
        return this.findUserById(id);
    }

    /**
     * Add user
     * @param user, the new user to add
     * @return the new user
     */
    @Override
    public Users addUser(Users user){
        return this.userRepository.save(user);
    }

    /**
     * Update user
     * @param id, the user identifier
     * @param user, the new details user to update
     * @return the updated user
     */
    @Override
    public Users updateUser(Integer id, Users user){
        Users userFound = this.findUserById(id);
        userFound.setName(user.getName());
        userFound.setSurname(user.getSurname());
        userFound.setEmail(user.getEmail());
        return this.userRepository.save(userFound);
    }

    /**
     * Deleted user
     * @param id, the user identifier 
     */
    @Override
    public void deleteUser(Integer id){
        Users userFound = this.findUserById(id);
        this.userRepository.delete(userFound);        
    }

    /**
     * Find user by Id. 
     * @param id, the user identifier 
     * @return the user found
     */
    private Users findUserById (Integer id){
        return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No exists a user with id: "+ id));
    }    
}
