package com.trip.controller;

import com.trip.service.ScenicFavoriteService;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicFavoriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2019-01-11.
 */
@RestController
public class ScenicFavoriteController {

    @Autowired
    private ScenicFavoriteService service;

    /**
     * 获取收藏的景点列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/favorite/scenic/{userId}",method = RequestMethod.GET)
    public ResponseVO getFavoriteScenics(@PathVariable Integer userId){
        return service.getFavoriteScenics(userId);
    }

    /**
     * 添加收藏
     * @param scenicFavoriteVO
     * @return
     */
    @RequestMapping(value = "/favorite/scenic",method = RequestMethod.POST)
    public ResponseVO addFavoriteScenic(@RequestBody ScenicFavoriteVO scenicFavoriteVO){
        return service.addFavoriteScenic(scenicFavoriteVO);
    }

    /**
     * 取消收藏
     * @param scenicFavoriteVO
     * @return
     */
    @RequestMapping(value = "/favorite/scenic/delete",method = RequestMethod.POST)
    public ResponseVO deleteFavoriteScenic(@RequestBody ScenicFavoriteVO scenicFavoriteVO){
        return service.deleteFavoriteScenic(scenicFavoriteVO);
    }


}
