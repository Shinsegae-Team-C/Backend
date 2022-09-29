package com.pjt.project.service;

import com.pjt.project.dto.LoginDto;
import com.pjt.project.mapper.UserMapper;
import com.pjt.project.model.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper userMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    /**
     * 회원가입을 합니다.
     *
     * @param user 회원가입할 사용자
     * @return 회원가입 결과 (json 형식)
     */
    @Override
    @SneakyThrows
    public String insertSignUpInfo(User user){

        if(userMapper.selectUser(user.getUserId()) != null){
            return "002";
        }
        if(userMapper.countUserPhone(user.getPhoneNumber()) > 0){
            return "011";
        }
        if(Objects.equals(checkPhoneNumber(user.getPhoneNumber()), "013")){
            user.setUserPw(passwordEncoder.encode(user.getUserPw()));
            userMapper.insertUser(user);
            log.info("회원가입 성공");
            return "001";
        }

        return checkPhoneNumber(user.getPhoneNumber());
    }


    /**
     *
     * @param loginDto 로그인할 ID, PW
     * @return 로그인 결과 {로그인한 사용자 정보, 코드값}
     */
    @Override
    @SneakyThrows
    public Map<String, Object> selectLoginInfo(LoginDto loginDto){

        Map<String, Object> userInfo = new HashMap<>();
        User user = userMapper.selectUser(loginDto.getUserId());

        if(user == null || !passwordEncoder.matches(loginDto.getUserPw(), user.getUserPw())){
            log.info("로그인 실패");
            userInfo.put("code", "012");
            userInfo.put("info", null);
        }
        else{
            log.info("로그인 성공");
            userInfo.put("code", "000");
            userInfo.put("info", user);
        }

        return userInfo;
    }


    /**
     * 유효한 전화번호인지 체크합니다.
     *
     * @param phoneNumber 사용자 휴대폰 번호
     * @return 휴대폰 번호 유효성 결과
     */
    @Override
    @SneakyThrows
    public String checkPhoneNumber(String phoneNumber) {
        final String regex = "[0-9]+";

        String[] phoneStr = phoneNumber.split("-");
        for(String p: phoneStr){
            if(!p.matches(regex)){
                return "010";
            }
        }

        if(phoneStr.length < 3 || phoneStr[0].length() != 3 || !phoneStr[0].startsWith("01") ||
                phoneStr[1].length() < 3 || phoneStr[1].length() > 4 || phoneStr[2].length() != 4){
            return "009";
        }

        return "013";
    }

}
