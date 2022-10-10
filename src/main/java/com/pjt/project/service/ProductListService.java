package com.pjt.project.service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ProductListService {

    Map<String, Object> selectProductItem(Map<String, String> req);

    List<Map<String, Object>> selectProductList(Map<String, String> req);

    Map<String, String> saveProduct(Map<String, String> req);
}
