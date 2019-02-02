package com.trip.mapper;

import com.trip.vo.TeamMessageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMessageMapper {

    int insert(TeamMessageVO record);

    List<TeamMessageVO> selectByTeam(Integer teamId);
}