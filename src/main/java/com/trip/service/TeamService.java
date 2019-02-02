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
}
