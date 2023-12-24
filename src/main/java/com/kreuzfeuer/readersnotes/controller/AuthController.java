package com.kreuzfeuer.readersnotes.controller;


import com.kreuzfeuer.readersnotes.dto.AuthRequest;
import com.kreuzfeuer.readersnotes.dto.AuthResponse;

import com.kreuzfeuer.readersnotes.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/registration")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.registerUser(authRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        authService.refreshToken(request, response);
//    }
}


