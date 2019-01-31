package com.trip.service;

import com.trip.mapper.ScenicFavoriteMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicFavoriteVO;
import com.trip.vo.ScenicInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2019-01-11.
 */
@Service
public class ScenicFavoriteServiceImpl implements ScenicFavoriteService{

    @Autowired
    private ScenicFavoriteMapper mapper;

    @Autowired
    private ScenicService scenicService;

    @Override
    public ResponseVO getFavoriteScenics(Integer userId) {
        List<Integer> scenicIdList=mapper.selectByUser(userId);
        List<ScenicInfoVO> scenicList=new ArrayList<>();
        for(Integer scenicId:scenicIdList){
            ScenicInfoVO scenic=scenicService.getScenic(scenicId,userId);
            if(scenic!=null){
                scenicList.add(scenic);
            }
        }
        return ResponseVO.buildSuccess(scenicList);
    }

    @Override
    public ResponseVO addFavoriteScenic(ScenicFavoriteVO scenicFavoriteVO) {
        Integer scenicInDb=mapper.select(scenicFavoriteVO);
        if(scenicInDb!=null)
            return ResponseVO.buildFailure("已经收藏该景点");
        mapper.insert(scenicFavoriteVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteFavoriteScenic(ScenicFavoriteVO scenicFavoriteVO) {
        mapper.delete(scenicFavoriteVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public boolean isFavorite(int userId, int scenicId) {
        Integer scenicInDb=mapper.select(new ScenicFavoriteVO(userId,scenicId));
        return scenicInDb!=null;
    }
}
