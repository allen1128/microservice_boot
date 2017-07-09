package com.xl.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.xl.demo.dao.TeamDao;
import com.xl.demo.domain.Player;
import com.xl.demo.domain.Team;

@SpringBootApplication
public class MicroserviceBootApplication extends SpringBootServletInitializer{

	/*
	 * use when run as war
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroserviceBootApplication.class);
	}

	/*
	 * user when run as jar
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBootApplication.class, args);
	}
	
	@PostConstruct
	public void init(){
		Set<Player> players = new HashSet<Player>();
		players.add(new Player("joe doe", "pitcher"));
		players.add(new Player("foo bar", "shortstop"));		
		Team team = new Team("Shanghai", "Pudong", players);
		teamDao.save(team);
	}
	
	@Autowired
	TeamDao teamDao;

}
