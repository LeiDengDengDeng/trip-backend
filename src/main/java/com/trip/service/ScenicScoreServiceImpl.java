package com.trip.service;

import com.trip.mapper.ScenicScoreMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicScoreMetrixVO;
import com.trip.vo.ScenicScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cong on 2019-01-06.
 */
@Service
public class ScenicScoreServiceImpl implements ScenicScoreService{

    @Autowired
    private ScenicScoreMapper mapper;

    @Override
    public ResponseVO addScore(ScenicScoreVO scoreVO) {
        //TODO 校验
        mapper.insertSelective(scoreVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateScore(ScenicScoreVO scoreVO) {
        mapper.update(scoreVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getScore(Integer scenicId) {
        return ResponseVO.buildSuccess(mapper.selectScores(scenicId));
    }

    @Override
    public ScenicScoreMetrixVO getMetrix(Integer scenicId) {
        List<ScenicScoreVO> list=mapper.selectScores(scenicId);
        int count=list.size();
        int sum=0;
        for(ScenicScoreVO scoreVO:list){
            sum+=scoreVO.getScore();
        }
        ScenicScoreMetrixVO metrixVO;
        if(count!=0){
            metrixVO=new ScenicScoreMetrixVO(count,sum/(double)count);
        }else {
            metrixVO=new ScenicScoreMetrixVO(0,0);
        }

        return metrixVO;
    }
}
