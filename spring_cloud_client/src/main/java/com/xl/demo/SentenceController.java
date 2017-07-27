package com.xl.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xl.demo.service.SentenceServiceImpl;

@Controller
public class SentenceController {
	
	@Autowired
	SentenceServiceImpl sentenceService;
	
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		return sentenceService.buildContent();
	}
	
	@RequestMapping("/ajax")
	public String ajaxSentence(){
		return "sentence";
	}
}
