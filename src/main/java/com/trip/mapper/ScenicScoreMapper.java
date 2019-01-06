package com.trip.mapper;

import com.trip.vo.ScenicScoreVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScenicScoreMapper {

    int insertSelective(ScenicScoreVO record);

    int update(ScenicScoreVO record);

    List<ScenicScoreVO> selectScores(Integer scenicId);

}