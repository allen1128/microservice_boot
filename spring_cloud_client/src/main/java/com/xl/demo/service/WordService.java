package com.xl.demo.service;

import com.xl.demo.domain.Word;

import rx.Observable;

public interface WordService {
	public Observable<Word> getVerb();
	public Observable<Word> getAdjective();
	public Observable<Word> getSubject();
	public Observable<Word> getArticle();
	public Observable<Word> getNoun();
}
