package com.pjt.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {
    List<Map<String, Object>> selectCartList(Map map);

    void insertOrder(Map map);
    void insertOrderDetail(Map map);
    void deleteCartInfo(Map map);

    void updateStockInfo(Map map);
}
