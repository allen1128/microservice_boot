package com.xl.demo.service;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xl.demo.dao.AdjectiveClient;
import com.xl.demo.dao.ArticleClient;
import com.xl.demo.dao.NounClient;
import com.xl.demo.dao.SubjectClient;
import com.xl.demo.dao.VerbClient;
import com.xl.demo.domain.Word;

import rx.Observable;
import rx.schedulers.Schedulers;

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
	
	@Autowired
	Executor executor;

	@Override
	@HystrixCommand(fallbackMethod="defaultVerb")
	public Observable<Word> getVerb() {
		return Observable.fromCallable(
				()-> new Word(verbService.getWord().toString(), Word.Role.verb)
		).subscribeOn(Schedulers.from(executor));
	}	

	public Word defaultVerb(){
		return new Word("(with no verb)", Word.Role.verb);
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultAdjective")
	public Observable<Word> getAdjective() {
		return Observable.fromCallable(
				()-> new Word(adjectiveService.getWord().toString(), Word.Role.adjective)
		).subscribeOn(Schedulers.from(executor));
	}
	
	public Word defaultAdjective(){
		return new Word("(with no adjective)", Word.Role.adjective);
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultSubject")
	public Observable<Word> getSubject() {
		return Observable.fromCallable(
				()-> new Word(subjectService.getWord().toString(), Word.Role.subject)						
		).subscribeOn(Schedulers.from(executor));
	}
	
	public Word defaultSubject(){
		return new Word("(with no subject)", Word.Role.subject);
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultArticle")
	public Observable<Word> getArticle() {
		return Observable.fromCallable(
				()-> new Word(articleService.getWord().toString(), Word.Role.article)
		).subscribeOn(Schedulers.from(executor));
	}
	
	public Word defaultArticle(){
		return new Word("(with no article)", Word.Role.article);
	}

	@Override
	@HystrixCommand(fallbackMethod="defaultNoun")
	public Observable<Word> getNoun() {
		return Observable.fromCallable(
				()-> new Word(nounService.getWord().toString(), Word.Role.noun)
		).subscribeOn(Schedulers.from(executor));
	}
	
	public Word defaultNoun(){
		return new Word("(with no noun)", Word.Role.noun);
	}
}
