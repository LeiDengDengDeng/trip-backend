package com.trip.mapper;

import com.trip.vo.InvitationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface InvitationMapper {

    int insert(InvitationVO record);

    List<InvitationVO> selectByReceiver(Integer receiverId);

    List<InvitationVO> selectByReceiverAndRead(@Param("receiverId") Integer recieverId,
                                               @Param("hasRead") boolean hasRead);

    void updateHasRead(@Param("id") int id,@Param("hasRead") boolean hasRead);

}