package com.platform.usermanager.dto;

import com.platform.usermanager.validation.annotation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDto(
    @NotBlank(message = "Username is required") String username,
    @ValidPassword String password,
    @NotBlank(message = "E-mail address is required") String email
) { }
