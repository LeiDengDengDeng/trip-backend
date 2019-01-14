package com.trip.controller;

import com.trip.service.ScenicService;
import com.trip.vo.ResponseVO;
import com.trip.vo.ScenicInfoVO;
import com.trip.vo.ScenicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2019-01-10.
 */
@RestController
public class ScenicController {

    @Autowired
    private ScenicService service;

    /**
     * 获取景点详细信息
     * @param scenicId
     * @return
     */
    @RequestMapping(value = "/scenic/{scenicId}",method = RequestMethod.GET)
    public ResponseVO getScenic(@PathVariable Integer scenicId){
        ScenicInfoVO info=service.getScenic(scenicId);
        if(info==null)
            return ResponseVO.buildFailure("景点信息不存在");
        return ResponseVO.buildSuccess(info);
    }

    /**
     * 添加景点
     * @param scenicVO
     * @return
     */
    @RequestMapping(value = "/scenic",method = RequestMethod.POST)
    public ResponseVO addScenic(@RequestBody ScenicVO scenicVO){
        return service.addScenic(scenicVO);
    }

    /**
     * 删除景点
     * @param scenicId
     * @return
     */
    @RequestMapping(value = "/scenic/delete/{scenicId}",method = RequestMethod.POST)
    public ResponseVO deleteScenic(@PathVariable Integer scenicId){
        return service.deleteScenic(scenicId);
    }

    /**
     * 更新景点
     * @param scenicVO
     * @return
     */
    @RequestMapping(value = "/scenic/update",method = RequestMethod.POST)
    public ResponseVO updateScenic(@RequestBody ScenicVO scenicVO){
        return service.updateScenic(scenicVO);
    }


}