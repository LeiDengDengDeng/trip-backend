package com.trip.controller;

import com.trip.service.TeamService;
import com.trip.vo.FriendVO;
import com.trip.vo.ResponseVO;
import com.trip.vo.TeamVO;
import com.trip.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fjj
 * @date 2019/1/7 下午12:07
 */
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "team/establish",method = RequestMethod.POST)
    public ResponseVO establishTeam(@RequestBody TeamVO teamVO){
        return teamService.establishTeam(teamVO);
    }

    @RequestMapping(value = "team/all",method = RequestMethod.GET)
    public ResponseVO getAllTeams(){
        return teamService.getAllTeams();
    }
}
