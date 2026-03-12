package com.ShopEase.service;

import com.ShopEase.model.dto.UserDto;
import com.ShopEase.model.dto.UserLoginRequest;

public interface UserService
{
    //register user
    public UserDto registerUser(UserDto userDto);

    //login user
    public UserDto loginUser(UserLoginRequest request);

    //get user by id
    public UserDto getUserById(Long userId);

    //get user by email
    public UserDto getUserByEmail(String email);

    //update user by id
    public UserDto updateUserById(Long userId,UserDto userDto);

    //delete user by id
    public void deleteUserById(Long userId);

}
