package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicInfoVO;
import com.trip.vo.ScenicVO;

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
    public ScenicInfoVO getScenic(Integer scenicId);

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
