package com.trip.service;

import com.trip.mapper.ScenicMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicInfoVO;
import com.trip.vo.ScenicScoreMetrixVO;
import com.trip.vo.ScenicVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-10.
 */
@Service
public class ScenicServiceImpl implements ScenicService{

    @Autowired
    private ScenicMapper mapper;

    @Autowired
    private ScenicScoreService scoreService;

    @Override
    public ScenicInfoVO getScenic(Integer scenicId) {
        //查询景点基本信息
        ScenicVO basicInfo=mapper.selectByPrimaryKey(scenicId);
        if(basicInfo==null)
            return null;
        ScenicInfoVO detail=new ScenicInfoVO();
        BeanUtils.copyProperties(basicInfo,detail);

        //查询评分
        ScenicScoreMetrixVO scoreMetrix=scoreService.getMetrix(scenicId);
        detail.setStar(scoreMetrix.getAverage());
        detail.setCommentCount(scoreMetrix.getCount());
        return detail;
    }

    @Override
    public ResponseVO addScenic(ScenicVO scenicVO) {
        mapper.insertSelective(scenicVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteScenic(Integer scenicId) {
        mapper.deleteByPrimaryKey(scenicId);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateScenic(ScenicVO scenicVO) {
        mapper.updateByPrimaryKeySelective(scenicVO);
        return ResponseVO.buildSuccess();
    }
}
