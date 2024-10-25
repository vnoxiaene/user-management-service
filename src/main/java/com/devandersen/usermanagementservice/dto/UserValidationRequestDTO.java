package com.devandersen.usermanagementservice.dto;

import lombok.Value;

@Value
public class UserValidationRequestDTO {

    String userName;
    String password;
}
