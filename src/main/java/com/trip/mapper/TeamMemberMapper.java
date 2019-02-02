package com.trip.mapper;

import com.trip.enumeration.TeamIdentity;
import com.trip.vo.EstablishedTeamVO;
import com.trip.vo.QuitTeamVO;
import com.trip.vo.TeamMemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author fjj
 * @date 2019/1/9 7:43 PM
 */
@Mapper
public interface TeamMemberMapper {
    int insertTeamMember(@Param("teamId") int teamId, @Param("userId") int userId, @Param("teamIdentity") TeamIdentity teamIdentity);

    List<TeamMemberVO> selectMemberByTeamId(int teamId);

    int selectMemberNumOfTeam(int teamId);

    List<Integer> selectTeamIdsByUserIdAndIdentity(@Param("userId") int  userId,@Param("teamIdentity") TeamIdentity teamIdentity);

    TeamIdentity selectMemberIdentityByTeamIdAndUserId(@Param("teamId") int teamId, @Param("userId") int userId);

    /**
     * 删除队伍成员（退出队伍）
     * @param quitTeamVO
     * @return
     */
    int deleteTeamMember(QuitTeamVO quitTeamVO);
}
