package com.yl.demo.learning.controller;

import com.yl.demo.learning.dto.ExternalUser;
import com.yl.demo.learning.repository.UserRepository;
import com.yl.demo.learning.entity.user.User;
import com.yl.demo.learning.response.api.ApiResponse;
import com.yl.demo.learning.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(value = "User Portal")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ApiResponse<?> getAllUsers() {

        return new ApiResponse<Object>(userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ApiResponse<?> getUser(@PathVariable("id") String id) throws Exception {

        return new ApiResponse<Object>(userRepository.findById(Long.valueOf(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ApiResponse<?> createUser(@RequestBody User user) throws Exception {

        return new ApiResponse<Object>(userRepository.save(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody ExternalUser externalUser) throws Exception{

        return userService.register(externalUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) throws Exception{

        return userService.login(user);
    }




}
