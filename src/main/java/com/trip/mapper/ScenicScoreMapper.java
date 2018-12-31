package com.trip.mapper;

import com.trip.vo.ScenicScoreVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScenicScoreMapper {

    int insertSelective(ScenicScoreVO record);

    int update(ScenicScoreVO record);

}