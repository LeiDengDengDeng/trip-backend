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

    @RequestMapping(value = "team/quit",method = RequestMethod.POST)
    public ResponseVO quitTeam(@RequestBody QuitTeamVO quitTeamVO){
        return teamService.quitTeam(quitTeamVO);
    }

    @RequestMapping(value = "team/update",method = RequestMethod.POST)
    public ResponseVO updateTeam(@RequestBody TeamVO teamVO){
        return teamService.updateTeam(teamVO);
    }

    @RequestMapping(value = "team/all",method = RequestMethod.GET)
    public ResponseVO getAllTeams(){
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "team/all/{scenicId}",method = RequestMethod.GET)
    public ResponseVO getAllTeamsByScenicId(@PathVariable int scenicId){
        return teamService.getAllTeamsByScenicId(scenicId);
    }

    @RequestMapping(value = "team/canJoin",method = RequestMethod.GET)
    public ResponseVO getAllTeamsCanJoin(){
        return teamService.getAllTeamsCanJoin();
    }

    @RequestMapping(value = "team/my/established/{userId}",method = RequestMethod.GET)
    public ResponseVO getMyEstablishedTeam(@PathVariable int userId){
        return teamService.getMyEstablishedTeam(userId);
    }

    @RequestMapping(value = "team/my/joined/{userId}",method = RequestMethod.GET)
    public ResponseVO getMyJoinedTeam(@PathVariable int userId){
        return teamService.getMyJoinedTeam(userId);
    }

    @RequestMapping(value = "team/{teamId}",method = RequestMethod.GET)
    public ResponseVO getTeamById(@PathVariable int teamId){
        return teamService.getTeamById(teamId);
    }

    @RequestMapping(value = "team/member/{teamId}",method = RequestMethod.GET)
    public ResponseVO getAllTeams(@PathVariable int teamId){
        return teamService.getAllMembersByTeamId(teamId);
    }

    @RequestMapping(value = "team/join",method = RequestMethod.POST)
    public ResponseVO joinTeam(@RequestBody JoinTeamVO joinTeamVO){
        return teamService.joinTeam(joinTeamVO);
    }

    @RequestMapping(value = "team/disband",method = RequestMethod.POST)
    public ResponseVO joinTeam(@RequestBody DisbandTeamVO disbandTeamVO){
        return teamService.disbandTeam(disbandTeamVO);
    }




}
