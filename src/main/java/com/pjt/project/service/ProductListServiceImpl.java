package com.pjt.project.service;

import com.pjt.project.mapper.ProductListMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProductListServiceImpl implements ProductListService{

    @Resource
    ProductListMapper productListMapper;

    @Override
    @SneakyThrows
    public Map<String, Object> selectProductItem(Map<String, String> req){
        Map<String, Object> result = productListMapper.selectProductItem(req);
        return result;
    }
    @Override
    @SneakyThrows
    public List<Map<String, Object>> selectProductList(Map<String, String> req){
        List<Map<String, Object>> result = productListMapper.selectProductList(req);
        return result;
    }

    @Override
    @SneakyThrows
    public Map<String, String> saveProduct(Map<String, String> req){

        Map<String, String> rm = new HashMap<String, String>();
        productListMapper.saveProduct(req);

        rm.put("result", "success");
        return rm;
    }
}
