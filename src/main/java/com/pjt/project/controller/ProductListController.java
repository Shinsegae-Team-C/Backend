package com.pjt.project.controller;

import com.pjt.project.service.ProductListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = {"상품 리스트 컨트롤러"})
@RestController
@RequestMapping("/productlist")
public class ProductListController {

    @Resource
    ProductListService productListService;

    @PostMapping("/selectProductItem")
    @ApiOperation(value="상품 하나 조회", notes="새로고침 시 사용")
    public Map<String, Object> selectProductItem(@RequestBody Map<String, String> req) throws Exception{
        //System.out.println(req);
        Map<String, Object> result = productListService.selectProductItem(req);
        return result;
    }

    @PostMapping("/selectProductList")
    @ApiOperation(value="상품 리스트 조회", notes="새로고침 시 사용")
    public List<Map<String, Object>> selectProductList(@RequestBody Map<String, String> req) throws Exception{
        //System.out.println(req);
        List<Map<String, Object>> result = productListService.selectProductList(req);
        return result;
    }

    @PostMapping("/saveProduct")
    @ApiOperation(value="장바구니에 담기", notes="상품 선택 후 장바구니에 담기")
    public Map<String, String> saveProduct(@RequestBody Map<String, String> req) throws Exception{
        Map<String, String> result = productListService.saveProduct(req);
        return result;
    }

}
