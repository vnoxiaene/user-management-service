package com.devandersen.usermanagementservice.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UserRequestVO {

    String userName;
    String password;
    String email;

}
