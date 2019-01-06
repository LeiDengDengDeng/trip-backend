package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicScoreMetrixVO;
import com.trip.vo.ScenicScoreVO;

/**
 * 景点评分
 * Created by cong on 2019-01-06.
 */
public interface ScenicScoreService {

    /**
     * 添加评分
     * @param scoreVO
     * @return
     */
    public ResponseVO addScore(ScenicScoreVO scoreVO);

    /**
     * 更新评分
     * @param scoreVO
     * @return
     */
    public ResponseVO updateScore(ScenicScoreVO scoreVO);

    /**
     * 获取景点的所有评分
     * @param scenicId
     * @return
     */
    public ResponseVO getScore(Integer scenicId);

    /**
     * 获取景点评分的统计
     * @param scenicId
     * @return
     */
    public ScenicScoreMetrixVO getMetrix(Integer scenicId);


}
