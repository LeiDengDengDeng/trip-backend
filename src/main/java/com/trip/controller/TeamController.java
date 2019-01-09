package com.trip.controller;

import com.trip.service.TeamService;
import com.trip.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "team/member/{teamId}",method = RequestMethod.GET)
    public ResponseVO getAllTeams(@PathVariable int teamId){
        return teamService.getAllMembersByTeamId(teamId);
    }

    @RequestMapping(value = "team/join",method = RequestMethod.POST)
    public ResponseVO joinTeam(@RequestBody JoinTeamVO joinTeamVO){
        return teamService.joinTeam(joinTeamVO);
    }




}
