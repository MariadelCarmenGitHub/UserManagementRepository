package com.practices.usermanagementbackend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.practices.usermanagementbackend.model.Users;

@Service
public interface UserService {
     /**
     * Get all users
     * @return List of all users
     */
    List<Users> getAllUsers();

    /***
     * Get User By Identifier
     * @param id, the user identifier
     * @return The User found
     */
    public Users getUserById(Integer id);

    /**
     * Add user
     * @param user, the new user to add
     * @return the new user
     */
    Users addUser(Users user);

    /**
     * Update user
     * @param id, the user identifier
     * @param user, the new details user to update
     * @return the updated user
     */
    Users updateUser(Integer id, Users user);

    /**
     * Deleted user
     * @param id, the user identifier 
     */
    void deleteUser(Integer id);
}
