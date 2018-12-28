package com.yl.demo.learning.controller;

import com.yl.demo.learning.config.websecurity.JwtHelper;
import com.yl.demo.learning.repository.UserRepository;
import com.yl.demo.learning.response.api.ApiResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(value = "Auth Portal")
@CrossOrigin(origins = "http://localhost:4200")
public class TokenController {

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/auth/authentication", method = RequestMethod.GET)
    public ApiResponse<?> authenticationInfo() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ApiResponse<Object>(authentication, HttpStatus.OK);
    }

    @RequestMapping(value = "/auth/token", method = RequestMethod.GET)
    public ApiResponse<?> generateAuthenticationToken(@RequestParam(value = "username", required = false) String username,
                                @RequestParam(value = "password", required = false) String password,
                                @RequestParam(value = "grant_type", required = false) String grantType,
                                @RequestParam(value = "redirect_uri", required = false) String redirectUri) throws Exception{
        log.info(username + " is requesting authentication token, password="+password);
        return new ApiResponse<Object>(jwtHelper.generateToken(username, password), HttpStatus.OK);
    }

    @RequestMapping(value = "/service/token", method = RequestMethod.GET)
    public ApiResponse<?> generateServiceToken(@RequestParam(value = "username", required = false) String username,
                                                      @RequestParam(value = "password", required = false) String password,
                                                      @RequestParam(value = "grant_type", required = false) String grantType,
                                                      @RequestParam(value = "redirect_uri", required = false) String redirectUri) throws Exception{
        log.info(username + " is requesting service token, password="+password);
        return new ApiResponse<Object>(jwtHelper.generateToken(username, password), HttpStatus.OK);
    }



}
