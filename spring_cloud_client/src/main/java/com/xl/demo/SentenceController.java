package com.xl.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xl.demo.service.SentenceService;


@RestController
public class SentenceController {
	
	@Autowired
	SentenceService sentenceService;
	
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		return sentenceService.buildContent();
	}
}
