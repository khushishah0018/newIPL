package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.repository.TeamRepository;
import com.wecp.progressive.service.TeamService;

public class TeamServiceImplJpa implements TeamService  {

    @Autowired
TeamRepository teamRepository;
 @Override
    public List<Team> getAllTeams() {
       return teamRepository.findAll();
    }

    @Override
    public int addTeam(Team team) {
      teamRepository.save(team);
        return team.getTeamId();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        return List.of();
    }

@Override
public void emptyArrayList(){
    TeamService.super.emptyArrayList();
}

}