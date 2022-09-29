package com.pjt.project.service;

import com.pjt.project.mapper.OrderMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Resource
    OrderMapper orderMapper;

    @Override
    @SneakyThrows
    public Map<String, Object> selectOrderList(Map<String, String> req){

        Map<String, Object> result = new HashMap<>();

        //주문 정보
        Map<String, Object> orderInfo = orderMapper.selectOrderInfo(req);

        //주문 상품 정보
        List<Map<String, Object>> orderDetailList = orderMapper.selectOrderDetailList(req);

        result.put("orderInfo", orderInfo);
        result.put("orderDetail", orderDetailList);

        return result;
    }
}
