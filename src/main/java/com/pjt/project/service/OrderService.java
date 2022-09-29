package com.pjt.project.service;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Map<String, Object> selectOrderList(Map<String, String> req) throws Exception;
}
