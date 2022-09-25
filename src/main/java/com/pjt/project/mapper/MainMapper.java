package com.pjt.project.mapper;

import com.pjt.project.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<Product> selectProductList(String productName);
}
