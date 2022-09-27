package com.pjt.project.service;

import java.util.List;
import java.util.Map;

public interface ProductListService {

    List<Map<String, Object>> selectProductList(Map<String, String> req);

    Map<String, String> saveProduct(Map<String, String> req);
}
