package com.ShopEase.controller;

import com.ShopEase.model.dto.UserDto;
import com.ShopEase.model.dto.UserLoginRequest;
import com.ShopEase.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    //register user
    @PostMapping
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
        UserDto userDto1 = userService.registerUser(userDto);

        return ResponseEntity.ok(userDto1);
    }

    //login User
    public ResponseEntity<UserDto> loginUser(@Valid @RequestBody UserLoginRequest request){
        UserDto userDto = userService.loginUser(request);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //get user by id
    @GetMapping("/{userId}")
    public void getUserById(@PathVariable Long userId){
        
    }
}
