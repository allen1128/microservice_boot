package com.xl.demo.domain;

public class Word {

	String word;	
	
	public Word() {
		super();
	}
	
	public Word(String word){
		this.word = word;
	}	
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return word;
	}
}
