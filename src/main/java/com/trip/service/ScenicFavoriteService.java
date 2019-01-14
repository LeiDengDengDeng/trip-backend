package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicFavoriteVO;

/**
 * 景点收藏
 * Created by cong on 2019-01-11.
 */
public interface ScenicFavoriteService {

    /**
     * 获取收藏的景点列表
     * @param userId
     * @return
     */
    public ResponseVO getFavoriteScenics(Integer userId);

    /**
     * 添加收藏
     * @param scenicFavoriteVO
     * @return
     */
    public ResponseVO addFavoriteScenic(ScenicFavoriteVO scenicFavoriteVO);

    /**
     * 取消收藏
     * @param scenicFavoriteVO
     * @return
     */
    public ResponseVO deleteFavoriteScenic(ScenicFavoriteVO scenicFavoriteVO);

}
