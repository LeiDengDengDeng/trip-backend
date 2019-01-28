package com.trip.mapper;

import com.trip.vo.ScenicVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScenicMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ScenicVO record);

    ScenicVO selectByPrimaryKey(Integer id);

    List<ScenicVO> selectAll();

    int updateByPrimaryKeySelective(ScenicVO record);
}