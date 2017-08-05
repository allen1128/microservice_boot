package com.xl.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xl.demo.domain.Team;
import com.xl.demo.service.TeamService;

@RestController
public class TeamController {	
	@Autowired TeamService teamService;
	
	/*@RequestMapping("/teams")
	public List<Team> getTeams() {
		return (List<Team>) teamRepository.findAll();
	}
	
	@RequestMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id){
		return teamRepository.findOne(id);
	}*/
	
	@RequestMapping("/teams/{name}")
	public Team findByName(@PathVariable String name){
		return teamService.findByName(name);
	}	
}
