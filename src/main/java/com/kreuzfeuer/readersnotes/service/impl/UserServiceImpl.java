package com.kreuzfeuer.readersnotes.service.impl;


import com.kreuzfeuer.readersnotes.domain.entity.User;
import com.kreuzfeuer.readersnotes.repository.UserRepository;
import com.kreuzfeuer.readersnotes.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repository.findByEmail(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
}
