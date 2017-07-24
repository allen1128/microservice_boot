package com.xl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.demo.dao.AdjectiveClient;
import com.xl.demo.dao.ArticleClient;
import com.xl.demo.dao.NounClient;
import com.xl.demo.dao.SubjectClient;
import com.xl.demo.dao.VerbClient;

@Service
public class SentenceService {
	
	@Autowired
	NounClient nounService;
	
	@Autowired
	AdjectiveClient adjectiveService;
	
	@Autowired
	SubjectClient subjectService;
	
	@Autowired
	ArticleClient articleService;
	
	@Autowired
	VerbClient verbService;
	
	
	public String buildContent(){
		return subjectService.getWord() + " " + verbService.getWord() + " " + articleService.getWord() + " "
				+ adjectiveService.getWord() + " " + nounService.getWord() + ".";
	}
}
