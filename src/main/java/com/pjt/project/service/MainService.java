package com.pjt.project.service;

import com.pjt.project.model.Product;

import java.util.List;

public interface MainService {
    List<Product>  selectProductList(String productName);
}
