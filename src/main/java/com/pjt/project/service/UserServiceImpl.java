package com.pjt.project.service;

import com.pjt.project.mapper.UserMapper;
import com.pjt.project.model.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    @SneakyThrows
    public boolean login(User user){
        System.out.println(user.getUserId());
        User u = userMapper.selectUser(user.getUserId());
        System.out.println(u);
        System.out.println(u.getUserId());

        return true;
    }
}
