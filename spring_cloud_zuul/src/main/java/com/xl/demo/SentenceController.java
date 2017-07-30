package com.xl.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SentenceController {
	
	@RequestMapping("/sentence")
	public String ajaxSentence(){
		return "sentence";
	}
}
