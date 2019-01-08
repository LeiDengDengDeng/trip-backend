package com.trip.mapper;

import com.trip.vo.TeamVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fjj
 * @date 2019/1/7 下午1:16
 */
@Mapper
public interface TeamMapper {

    /**
     * 这里返回一个创建成功后的teamId,用于接下来插入team_member表中
     * @param teamVO
     * @return
     */
    int insertTeam(TeamVO teamVO);
}
