package com.pjt.project.service;

import java.util.List;
import java.util.Map;

public interface CartService {

    List<Map<String, Object>> selectCartList(Map<String, String> req) throws Exception;

    Map<String, String> saveOrder(Map<String,Object> req) throws Exception;

    Map<String, String> deleteCartInfo(Map<String, String> req) throws Exception;
}
