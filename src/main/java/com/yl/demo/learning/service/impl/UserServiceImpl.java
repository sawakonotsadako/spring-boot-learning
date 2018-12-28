package com.yl.demo.learning.service.impl;

import com.yl.demo.learning.config.websecurity.JwtHelper;
import com.yl.demo.learning.dto.ExternalUser;
import com.yl.demo.learning.entity.user.User;
import com.yl.demo.learning.repository.UserRepository;
import com.yl.demo.learning.response.api.ApiResponse;
import com.yl.demo.learning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtHelper jwtHelper;


    @Override
    public ResponseEntity<?> register(ExternalUser externalUser) throws Exception {
        Optional<User> optionalUsr = userRepository.findByUsername(externalUser.getUsername());
        if (optionalUsr.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("user already registered:" + externalUser.getUsername());
        }
        // Send Email
        return ResponseEntity.ok("we have sent an email to you, please check your email box");
    }

    @Override
    public ApiResponse<?> activate(User user) throws Exception {
        return null;
    }

    @Override
    public ApiResponse<?> terminate(User user) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> login(User user) throws Exception {

        Optional<User> optionalUsr = userRepository.findByUsername(user.getUsername());
        if (!optionalUsr.isPresent()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found or registered:" + user.getUsername());
        }

        User storedUsr = optionalUsr.get();
        if (storedUsr.isRegistered()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("account registered but not activated");
        }

        if (storedUsr.isBeingUsed()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("account is being used, please logout first");
        }

        if (storedUsr.isAccountExpired()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("account expired");
        }

        if (storedUsr.isAccountLocked()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("account locked");
        }

        if (storedUsr.isCredentialsNonExpired()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("account password expired");
        }

        return ResponseEntity.ok(jwtHelper.generateToken(user.getUsername(), user.getPassword()));
    }

    @Override
    public ApiResponse<?> logout(User user) throws Exception {
        return null;
    }

    @Override
    public ApiResponse<?> getUsersInfo() {
        return null;
    }

    @Override
    public ApiResponse<?> updateUserInfo(User updateUser) throws Exception {
        return null;
    }

    @Override
    public boolean isAccountExpired(User user) {
        return !user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountLocked(User user) {
        return !user.isAccountNonLocked();
    }

    @Override
    public boolean isAccountEnabled(User user) {
        return user.isEnabled();
    }

    @Override
    public boolean isCredentialExpired(User user) {
        return !user.isCredentialsNonExpired();
    }

    @Override
    public ApiResponse<?> getUserInfo(User user) throws Exception {
        return null;
    }

}
