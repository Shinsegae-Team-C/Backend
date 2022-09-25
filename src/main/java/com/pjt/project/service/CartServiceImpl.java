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
        List<Map<String, Object>> result = cartMapper.selectCartList(req);
        return result;
    }

    @Override
    @SneakyThrows
    public Map<String, String> saveOrder(List<Map<String,String>> req){

        Map<String, String> rm = new HashMap<String, String>();

        //order 넣기
        cartMapper.insertOrder(req.get(0));

        //orderDetail 넣기, stock 업데이트
        for(int i = 0; i < req.size(); i++){
            cartMapper.insertOrderDetail(req.get(i));
            cartMapper.updateStockInfo(req.get(i));
        }

        //deleteCartInfo 지우기
        cartMapper.deleteCartInfo(req.get(0));

        rm.put("result", "success");

        return rm;
    }
}
