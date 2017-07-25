package com.xl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
	
	@Autowired
	WordService wordService;	
	
	@Override
	public String buildContent(){
		return wordService.getSubject().toString() + " " + wordService.getVerb().toString() + " " + wordService.getArticle().toString() + " "
				+ wordService.getAdjective().toString() + " " + wordService.getNoun().toString() + ".";
	}
}
