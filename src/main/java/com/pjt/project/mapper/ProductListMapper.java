package com.pjt.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductListMapper {

    Map<String, Object> selectProductItem(Map<String, String> map);
    List<Map<String, Object>> selectProductList(Map map);

    void saveProduct(Map<String, String> map);
    //void insertProduct(Map<String, String> map);
    //void updateProduct(Map<String, String> map);
    //int chkProductInCart(Map map);
}
