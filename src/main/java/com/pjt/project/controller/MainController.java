package com.pjt.project.controller;

import com.pjt.project.model.Product;
import com.pjt.project.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = {"메인 페이지 Controller"})
@RestController
@Slf4j
public class MainController {

    @Resource
    MainService mainService;

    @PostMapping("/main")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ApiOperation(value="상품 검색", notes="사용자가 말한 상품을 조회합니다.")
    public List<Product> selectProductList(@RequestBody Map<String,String> productName){
        log.info("{} 상품이 검색되었습니다.", productName);
        return mainService.selectProductList(productName);
    }

    @GetMapping("/test")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void test(Map<String,String> productName){
        log.info("{} 상품이 검색되었습니다.", productName);
    }
}
