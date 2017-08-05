package com.xl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.demo.domain.Team;
import com.xl.demo.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepository;

	public Team findByName(String name) {
		return teamRepository.findByName(name);
	}
}
