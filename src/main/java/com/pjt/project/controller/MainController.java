package com.pjt.project.controller;

import com.pjt.project.model.Product;
import com.pjt.project.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = {"메인 페이지 Controller"})
@RestController
public class MainController {

    @Resource
    MainService mainService;

    @PostMapping("/main")
    @ApiOperation(value="상품 검색", notes="사용자가 말한 상품을 조회합니다.")
    public List<Product> selectProductList(@RequestParam String productName){
        return mainService.selectProductList(productName);
    }
}
