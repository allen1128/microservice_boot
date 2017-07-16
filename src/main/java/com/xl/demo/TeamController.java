package com.xl.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xl.demo.dao.TeamDao;
import com.xl.demo.domain.Team;

@RestController
public class TeamController {
	
	@Autowired TeamDao teamDao;

	@RequestMapping("team/{name}")
	public Team team(@PathVariable String name){
		return teamDao.findByName(name);
	}
}
