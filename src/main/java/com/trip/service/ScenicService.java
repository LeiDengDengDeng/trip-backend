package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicInfoVO;
import com.trip.vo.ScenicVO;

import java.util.List;

/**
 * 景点信息管理
 * Created by cong on 2019-01-10.
 */
public interface ScenicService {

    /**
     * 获取景点详细信息
     * @param scenicId
     * @return
     */
    public ScenicInfoVO getScenic(Integer scenicId,Integer userId);

    /**
     * 获取所有景点
     * @return
     */
    public List<ScenicInfoVO> getAllScenic();

    /**
     * 根据名称模糊搜索
     * @param name
     * @return
     */
    public ResponseVO searchScenic(String name);

    /**
     * 添加景点
     * @param scenicVO
     * @return
     */
    public ResponseVO addScenic(ScenicVO scenicVO);

    /**
     * 删除景点
     * @param scenicId
     * @return
     */
    public ResponseVO deleteScenic(Integer scenicId);

    /**
     * 更新景点
     * @param scenicVO
     * @return
     */
    public ResponseVO updateScenic(ScenicVO scenicVO);


}
