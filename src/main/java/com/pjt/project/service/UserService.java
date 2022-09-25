package com.pjt.project.service;

import com.pjt.project.dto.LoginDto;
import com.pjt.project.model.User;

import java.util.Map;

public interface UserService {
    String insertSignUpInfo(User user);
    Map<String, Object> selectLoginInfo(LoginDto loginDto);
    String checkPhoneNumber(String phoneNumber);
}
