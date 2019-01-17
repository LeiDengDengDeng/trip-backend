package com.trip.mapper;

import com.trip.enumeration.TeamIdentity;
import com.trip.vo.TeamMemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
