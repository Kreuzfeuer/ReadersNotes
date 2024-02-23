package com.kreuzfeuer.readersnotes.service;

import com.kreuzfeuer.readersnotes.domain.dto.AuthRequest;
import com.kreuzfeuer.readersnotes.domain.dto.AuthResponse;


public interface AuthService {
    AuthResponse authenticate(AuthRequest request);

    AuthResponse registerUser(AuthRequest authRequest);

}
