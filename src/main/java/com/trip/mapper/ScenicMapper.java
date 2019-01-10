package com.trip.mapper;

import com.trip.vo.ScenicVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScenicMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ScenicVO record);

    ScenicVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScenicVO record);
}