package com.xl.demo.service;

import com.xl.demo.domain.Word;

public interface WordService {
	public Word getVerb();
	public Word getAdjective();
	public Word getSubject();
	public Word getArticle();
	public Word getNoun();
}
