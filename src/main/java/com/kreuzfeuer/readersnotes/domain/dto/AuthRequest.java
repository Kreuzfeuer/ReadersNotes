package com.kreuzfeuer.readersnotes.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
@Schema(description = "Authorization request")
public class AuthRequest {

    @Schema(description = "Email")
    @NotBlank(message = "Email cannot be null")
    @Size(min = 5, max = 32, message = "Login must be from 3 to 16 characters")
    String email;

    @Schema(description = "Password")
    @NotBlank(message = "Password cannot be null")
    @Size(min = 3, message = "Password must be at least 3 characters long")
    String password;


}
