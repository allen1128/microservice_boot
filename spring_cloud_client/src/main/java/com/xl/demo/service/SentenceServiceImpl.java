package com.xl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SentenceServiceImpl implements SentenceService {
	
	@Autowired
	WordService wordService;	
	
	@Override
	@HystrixCommand(fallbackMethod="defaultContent")
	public String buildContent(){
		return wordService.getSubject().toString() + " " + wordService.getVerb().toString() + " " + wordService.getArticle().toString() + " "
				+ wordService.getAdjective().toString() + " " + wordService.getNoun().toString() + ".";
	}
	
	public String defaultContent(){
		return "no content";
	}
}
