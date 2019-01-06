package com.trip.controller;

import com.trip.service.ScenicScoreService;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 景点评分
 * Created by cong on 2019-01-06.
 */
@RestController
public class ScenicScoreController {

    @Autowired
    private ScenicScoreService service;

    /**
     * 添加评分
     * @param scoreVO
     * @return
     */
    @RequestMapping(value = "/score",method = RequestMethod.POST)
    public ResponseVO addScore(@RequestBody ScenicScoreVO scoreVO){
        return service.addScore(scoreVO);
    }

    /**
     * 更新评分
     * @param scoreVO
     * @return
     */
    @RequestMapping(value = "/score/update",method = RequestMethod.POST)
    public ResponseVO updateScore(@RequestBody ScenicScoreVO scoreVO){
        return service.updateScore(scoreVO);
    }

    /**
     * 获取景点的所有评分
     * @param scenicId
     * @return
     */
    @RequestMapping(value = "/scores/{scenicId}",method = RequestMethod.GET)
    public ResponseVO getScore(@PathVariable Integer scenicId){
        return service.getScore(scenicId);
    }

}
