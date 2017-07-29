package com.xl.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xl.demo.domain.Player;
import com.xl.demo.domain.Team;
import com.xl.demo.repository.TeamRepository;

@SpringBootApplication
public class Application{
	/*
	 * use when run as war
	 * 
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#
	 * configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	
	@Autowired
	TeamRepository teamRepository;
	
	/*
	 * user when run as jar
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> set = new HashSet<>();
		set.add(new Player("Big Easy", "Showman"));
		set.add(new Player("Buckets", "Guard"));
		set.add(new Player("Dizzy", "Guard"));
		
		list.add(new Team("Harlem", "Globetrotters", set));
		list.add(new Team("Washington","Generals",null));

		teamRepository.save(list);
	} 
}
