package com.kreuzfeuer.readersnotes.service.impl;


import com.kreuzfeuer.readersnotes.entity.User;
import com.kreuzfeuer.readersnotes.repository.UserRepository;
import com.kreuzfeuer.readersnotes.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    /**
     * Search by id. Using the default JpaRepository implementation .
     *
     * @param id - User id
     * @return User
     */

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean createUser(User user) {

        String email = user.getEmail();

        if (repository.findByEmail(email).isPresent()) {
            return false;
        }

        user.setActive(true);
        user.setPassword(new BCryptPasswordEncoder(8).encode(user.getPassword()));


        repository.save(user);

        log.info("Saving new User with email: {}", email);
        return true;
    }

    @Override
    public User findByLogin(String email) {
        return repository.findByEmail(email).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repository.findByEmail(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
}
