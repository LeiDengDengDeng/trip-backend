package com.trip.service;

import com.trip.vo.*;

/**
 * @author fjj
 * @date 2019/1/7 下午1:13
 */
public interface TeamService {
    /**
     * 创建出游队伍
     * @param teamVO
     * @return
     */
    ResponseVO establishTeam(TeamVO teamVO);

    /**
     * 所有队伍
     * @return
     */
    ResponseVO getAllTeams();

    ResponseVO getAllMembersByTeamId(int teamId);

    ResponseVO joinTeam(JoinTeamVO joinTeamVO);

    ResponseVO getTeamById(int teamId);

    ResponseVO updateTeam(TeamVO teamVO);

    ResponseVO getMyEstablishedTeam(int userId);

    ResponseVO getMyJoinedTeam(int userId);

    ResponseVO quitTeam(QuitTeamVO quitTeamVO);

    ResponseVO disbandTeam(DisbandTeamVO disbandTeamVO);

    ResponseVO getAllTeamsByScenicId(int scenicId);

    ResponseVO getAllTeamsCanJoin();

    ResponseVO getMyEstablishedTeamNew(EstablishedTeamVO establishedTeamVO);

    ResponseVO searchTeam(SearchTeamVO searchTeamVO);

    /**
     * 根据id查找用户历史出游(这里处理成返回该用户参加过的已经结束的队伍信息)
     * @param id
     * @return
     */
    ResponseVO getUserHistory(int id);
}
