package com.pjt.project.service;

import com.pjt.project.mapper.CartMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CartServiceImpl implements CartService{

    @Resource
    CartMapper cartMapper;

    @Override
    @SneakyThrows
    public List<Map<String, Object>> selectCartList(Map<String, String> req){
        return cartMapper.selectCartList(req);
    }

    @Override
    @SneakyThrows
    public Map<String, String> saveOrder(Map<String,Object> req){

        Map<String, String> rm = new HashMap<String, String>();
        List<Map<String, String>> result = (List<Map<String, String>>) req.get("result");
        //order 넣기
        cartMapper.insertOrder(result.get(0));

        //orderDetail 넣기, stock 업데이트
        for(int i = 0; i < result.size(); i++){
            cartMapper.insertOrderDetail(result.get(i));

            //deleteCartInfo 지우기
            cartMapper.deleteCartInfo(result.get(i));
        }
        rm.put("result", "success");

        return rm;
    }

    @Override
    @SneakyThrows
    public Map<String, String> deleteCartInfo(Map<String, String> req) {

        Map<String, String> rm = new HashMap<String, String>();
        cartMapper.deleteCartInfo(req);
        rm.put("result", "OK");
        return rm;
    }
}
