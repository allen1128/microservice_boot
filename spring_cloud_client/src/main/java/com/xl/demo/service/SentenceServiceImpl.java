package com.xl.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xl.demo.domain.Word;
import com.xl.demo.domain.Word.Role;

import rx.Observable;

@Service
public class SentenceServiceImpl implements SentenceService {
	
	@Autowired
	WordService wordService;	
	
	@Override
	//@HystrixCommand(fallbackMethod="defaultContent")
	public String buildContent(){
		TreeMap<Role, Word> words = new TreeMap<>();
		List<Observable<Word>> observables = createObservables();
		CountDownLatch latch = new CountDownLatch(observables.size());
		
		Observable.merge(observables)
			.subscribe((word)->{
				words.put(word.getRole(), word);
				latch.countDown();
			});
		
		waitForAll(latch);
		return doBuild(words);
	}
	
	private String doBuild(Map<Role, Word> words) {
		StringBuilder output = new StringBuilder();
		for (Role role: words.keySet()){
			output.append(words.get(role).toString()).append(' ');
		}		
		return output.toString();
	}
	
	private List<Observable<Word>> createObservables(){
		List<Observable<Word>> observables = new ArrayList<>();
		observables.add(wordService.getSubject());
		observables.add(wordService.getVerb());
		observables.add(wordService.getArticle());
		observables.add(wordService.getAdjective());
		observables.add(wordService.getNoun());
		return observables;
	}

	private void waitForAll(CountDownLatch latch) {
		try {
			latch.await();
		} catch(InterruptedException ex){
			ex.printStackTrace();
		}		
	}

	public String defaultContent(){
		return "no content";
	}
}
