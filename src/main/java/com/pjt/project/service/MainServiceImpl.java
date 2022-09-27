package com.pjt.project.service;

import com.pjt.project.mapper.MainMapper;
import com.pjt.project.model.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MainServiceImpl implements MainService{

    @Resource
    MainMapper mainMapper;

    @Override
    @SneakyThrows
    public List<Product> selectProductList(Map<String,String> productName){
        return mainMapper.selectProductList(productName);
    }
}
