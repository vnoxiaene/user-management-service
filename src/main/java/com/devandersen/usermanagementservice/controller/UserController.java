package com.devandersen.usermanagementservice.controller;

import com.devandersen.usermanagementservice.dto.UserRequestVO;
import com.devandersen.usermanagementservice.dto.UserValidationRequestDTO;
import com.devandersen.usermanagementservice.dto.UserValidationResponseDTO;
import com.devandersen.usermanagementservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestVO userRequestVO){
        userService.createUser(userRequestVO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/validate")
    public ResponseEntity<UserValidationResponseDTO> validateUser(@RequestBody UserValidationRequestDTO userValidationRequestDTO){
        return ResponseEntity.ok(userService.validateUser(userValidationRequestDTO));
    }

}
