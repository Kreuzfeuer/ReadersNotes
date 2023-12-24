package com.kreuzfeuer.readersnotes.service;


import com.kreuzfeuer.readersnotes.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
     User findById(Long id);
     boolean createUser(User user);

     User findByLogin(String login);

}
