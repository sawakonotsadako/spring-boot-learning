package com.yl.demo.learning.service;

import com.yl.demo.learning.dto.ExternalUser;
import com.yl.demo.learning.entity.user.User;
import com.yl.demo.learning.response.api.ApiResponse;
import org.springframework.http.ResponseEntity;


public interface UserService {

    ResponseEntity<?> register(ExternalUser externalUser)throws Exception;

    ApiResponse<?> activate(User user) throws Exception;

    ApiResponse<?> terminate(User user) throws Exception;

    ResponseEntity<?> login(User user) throws Exception;

    ApiResponse<?> logout(User user) throws Exception;

    ApiResponse<?> getUsersInfo();

    ApiResponse<?> getUserInfo(User user) throws Exception;

    ApiResponse<?> updateUserInfo(User updateUser) throws Exception;

    boolean isAccountExpired(User user);

    boolean isAccountLocked(User user);

    boolean isAccountEnabled(User user);

    boolean isCredentialExpired(User user);

}
