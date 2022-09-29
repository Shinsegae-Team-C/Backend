package com.pjt.project.service;

import com.pjt.project.model.Product;

import java.util.List;
import java.util.Map;

public interface MainService {
    List<Product>  selectProductList(Map<String,String> productName);

}
