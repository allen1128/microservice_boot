package com.xl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.demo.dao.WordDaoImpl;

@Service
public class SentenceService {
	
	@Autowired
	WordDaoImpl adjectiveService;
	
	@Autowired
	WordDaoImpl verbService;
	
	@Autowired
	WordDaoImpl nounService;
	
	@Autowired
	WordDaoImpl articleService;
	
	@Autowired
	WordDaoImpl subjectService;
	
	public String buildContent(){
		return subjectService.getWord() + " " + verbService.getWord() + " " + articleService.getWord() + " "
				+ adjectiveService.getWord() + " " + nounService.getWord() + ".";
	}
}
