package com.pjt.project.controller;

import com.pjt.project.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = {"장바구니 컨트롤러"})
@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    CartService cartService;

    @PostMapping("/selectCartList")
    @ApiOperation(value="장바구니 리스트 조회", notes="")
    public List<Map<String, Object>> selectCartList(@RequestBody Map<String, String> req) throws Exception{
        List<Map<String, Object>> result = cartService.selectCartList(req);
        return result;
    }

    @PostMapping("/saveOrder")
    @ApiOperation(value="주문하기", notes="주문하기")
    public Map<String, String> saveOrder(@RequestBody List<Map<String,String>> req) throws Exception{
        return cartService.saveOrder(req);
    }

}
