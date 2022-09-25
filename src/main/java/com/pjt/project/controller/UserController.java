package com.pjt.project.controller;

import com.pjt.project.dto.LoginDto;
import com.pjt.project.model.User;
import com.pjt.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Api(tags = {"사용자 정보 Controller"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/signUp")
    @ApiOperation(value="회원가입", notes="회원가입을 진행합니다.")
    public String signup(@RequestBody User user){
        return userService.insertSignUpInfo(user);
    }
    @PostMapping("/login")
    @ApiOperation(value="로그인", notes="로그인합니다.")
    public Map<String, Object> login(@RequestBody LoginDto loginDto){
        return userService.selectLoginInfo(loginDto);
    }

}
