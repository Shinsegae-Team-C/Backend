package com.pjt.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductListMapper {

    List<Map<String, Object>> selectProductList(Map map);

    void saveProduct(Map<String, String> map);
    //void insertProduct(Map<String, String> map);
    //void updateProduct(Map<String, String> map);
    //int chkProductInCart(Map map);
}
