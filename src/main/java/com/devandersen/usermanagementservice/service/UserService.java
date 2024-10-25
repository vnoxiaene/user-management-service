package com.devandersen.usermanagementservice.service;

import com.devandersen.usermanagementservice.dto.UserRequestVO;
import com.devandersen.usermanagementservice.dto.UserValidationRequestDTO;
import com.devandersen.usermanagementservice.dto.UserValidationResponseDTO;
import com.devandersen.usermanagementservice.mappers.UserMapper;
import com.devandersen.usermanagementservice.model.User;
import com.devandersen.usermanagementservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserValidationResponseDTO validateUser(UserValidationRequestDTO userValidationRequestDTO){
        Optional<User> userOptional = userRepository.findByUserName(userValidationRequestDTO.getUserName());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return new UserValidationResponseDTO(user.getPassword().equals(userValidationRequestDTO.getPassword()));
        }
        else{
            return new UserValidationResponseDTO(false);
        }
    }

    public void createUser(UserRequestVO userRequestVO){
        User user = UserMapper.INSTANCE.userRequestVOtoUser(userRequestVO);
        userRepository.save(user);
    }

}
