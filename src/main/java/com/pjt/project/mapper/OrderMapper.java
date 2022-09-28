package com.pjt.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    Map<String, Object> selectOrderInfo(Map map);

    List<Map<String, Object>> selectOrderDetailList(Map map);
}
