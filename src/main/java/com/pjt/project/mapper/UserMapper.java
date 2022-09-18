package com.pjt.project.mapper;

import com.pjt.project.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectUser(String userId);
}
