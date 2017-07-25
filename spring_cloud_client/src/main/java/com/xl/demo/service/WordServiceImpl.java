package com.xl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xl.demo.dao.AdjectiveClient;
import com.xl.demo.dao.ArticleClient;
import com.xl.demo.dao.NounClient;
import com.xl.demo.dao.SubjectClient;
import com.xl.demo.dao.VerbClient;
import com.xl.demo.domain.Word;

@Service
public class WordServiceImpl implements WordService{
	
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

	@Override
	@HystrixCommand(fallbackMethod="defaultVerb")
	public Word getVerb() {
		return verbService.getWord();
	}	

	public Word defaultVerb(){
		return new Word("(with no verb)");
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultAdjective")
	public Word getAdjective() {
		return adjectiveService.getWord();
	}
	
	public Word defaultAdjective(){
		return new Word("(with no adjective)");
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultSubject")
	public Word getSubject() {
		return subjectService.getWord();
	}
	
	public Word defaultSubject(){
		return new Word("(with no subject)");
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultArticle")
	public Word getArticle() {
		return articleService.getWord();
	}
	
	public Word defaultArticle(){
		return new Word("(with no article)");
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultNoun")
	public Word getNoun() {
		return nounService.getWord();
	}
	
	public Word defaultNoun(){
		return new Word("(with no noun)");
	}
}
