package com.trip.service;

import com.trip.mapper.ScenicMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicInfoVO;
import com.trip.vo.ScenicScoreMetrixVO;
import com.trip.vo.ScenicVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2019-01-10.
 */
@Service
public class ScenicServiceImpl implements ScenicService{

    @Autowired
    private ScenicMapper mapper;

    @Autowired
    private ScenicScoreService scoreService;

    @Autowired
    private ScenicFavoriteService favoriteService;

    @Override
    public ScenicInfoVO getScenic(Integer scenicId,Integer userId) {
        //查询景点基本信息
        ScenicVO basicInfo=mapper.selectByPrimaryKey(scenicId);
        ScenicInfoVO detail=getDetail(basicInfo);
        detail.setFavorite(favoriteService.isFavorite(userId,scenicId));
        return detail;
    }

    @Override
    public List<ScenicInfoVO> getAllScenic() {
        List<ScenicVO> scenics=mapper.selectAll();
        return getDetail(scenics);
    }

    private List<ScenicInfoVO> getDetail(List<ScenicVO> scenics){
        List<ScenicInfoVO> result=new ArrayList<>();
        for(ScenicVO scenic:scenics){
            ScenicInfoVO detail=getDetail(scenic);
            if(detail!=null){
                result.add(detail);
            }
        }
        return result;
    }

    @Override
    public ResponseVO searchScenic(String name) {
        return ResponseVO.buildSuccess(getDetail(mapper.selectByName(name)));
    }

    private ScenicInfoVO getDetail(ScenicVO basicInfo){
        if(basicInfo==null)
            return null;
        ScenicInfoVO detail=new ScenicInfoVO();
        BeanUtils.copyProperties(basicInfo,detail);

        //查询评分
        ScenicScoreMetrixVO scoreMetrix=scoreService.getMetrix(basicInfo.getId());
        detail.setStar(scoreMetrix.getAverage());
        detail.setCommentCount(scoreMetrix.getCount());
        return detail;
    }

    @Override
    public ResponseVO addScenic(ScenicVO scenicVO) {
        String pinyin=scenicVO.getPinyin();
        if(!StringUtils.isEmpty(pinyin)){
            scenicVO.setPinyin(pinyin.toUpperCase());
        }
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
