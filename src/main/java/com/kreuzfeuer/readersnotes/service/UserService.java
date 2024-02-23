package com.kreuzfeuer.readersnotes.service;


import com.kreuzfeuer.readersnotes.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

     User findByEmail(String email);

}
