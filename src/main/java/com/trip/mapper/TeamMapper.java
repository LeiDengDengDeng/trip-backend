package com.trip.mapper;

import com.trip.vo.JoinTeamVO;
import com.trip.vo.TeamInfoVO;
import com.trip.vo.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 找出所有队伍
     * @return
     */
    List<TeamInfoVO> selectAllTeams();

    /**
     * 根据teamid查找队伍信息
     */
    TeamInfoVO selectTeamById(int teamId);

    int updateTeam(TeamVO teamVO);

//    List<TeamInfoVO> selectTeamsByLeaderId(int userId);

//    List<TeamInfoVO> selectTeamsByMemberId(int userId);

    List<TeamInfoVO> selectBatchOfTeamByIds(List<Integer> teamIds);
}
