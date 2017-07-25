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
	public Word getVerb() {
		return verbService.getWord();
	}

	@Override
	
	public Word getAdjective() {
		return adjectiveService.getWord();
	}

	@Override
	public Word getSubject() {
		return subjectService.getWord();
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
	public Word getNoun() {
		return nounService.getWord();
	}
}
