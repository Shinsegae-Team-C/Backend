package com.pjt.project.controller;

import com.pjt.project.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = {"주문 확인 컨트롤러"})
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/selectOrderList")
    @ApiOperation(value="주문 정보 리스트 조회", notes="")
    public Map<String, Object> selectOrderList(@RequestBody Map<String, String> req) throws Exception{
        Map<String, Object> result = orderService.selectOrderList(req);
        return result;
    }

}
