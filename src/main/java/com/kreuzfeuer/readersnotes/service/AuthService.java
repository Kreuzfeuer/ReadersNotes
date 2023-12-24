package com.kreuzfeuer.readersnotes.service;

import com.kreuzfeuer.readersnotes.dto.AuthRequest;
import com.kreuzfeuer.readersnotes.dto.AuthResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);

    AuthResponse registerUser(AuthRequest authRequest);

    void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException;
}
