package com.pjt.project.controller;

import com.pjt.project.model.User;
import com.pjt.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"사용자 정보 컨트롤러"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value="로그인", notes="로그인합니다")
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }
}
