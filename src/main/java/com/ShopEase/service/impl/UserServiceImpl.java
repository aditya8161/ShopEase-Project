package com.ShopEase.service.impl;

import com.ShopEase.exception.UserNotFoundException;
import com.ShopEase.model.dto.UserDto;
import com.ShopEase.model.dto.UserLoginRequest;
import com.ShopEase.model.entity.User;
import com.ShopEase.repository.UserRepository;
import com.ShopEase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    private final ModelMapper mapper;
    private final UserRepository userRepo;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepo) {
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        user.setRole("ROLE_USER");
        User savedUser = userRepo.save(user);
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto loginUser(UserLoginRequest request) {
        Optional<User> optionalUser = userRepo.findByEmail(request.getEmail());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getPassword().equals(request.getPassword())){
                return mapper.map(user, UserDto.class);
            }
            else
            {
                throw new RuntimeException("Wrong Password...!");
            }
        }
        else
        {
            throw new RuntimeException("Wrong Email and password...!");
        }
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found Exception : "+userId));
        return mapper.map(user,UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User Not Found Exception : "+email));
        return mapper.map(user,UserDto.class);
    }

    @Override
    public UserDto updateUserById(Long userId,UserDto userDto) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User Not Found Exception : "+userId));

        // 2. Update the fields
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        //update phone
        existingUser.setPhoneList(userDto.getPhoneList());
        //role update by admin and password only user update

        User updatedUser = userRepo.save(existingUser);
        return mapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found Exception : "+userId));
        String email = user.getEmail();
        userRepo.deleteById(user.getId());
        log.info("User Deleted successfully : {}",email);
    }
}
