package com.xl.demo;

import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableHystrixDashboard 
public class SentenceController {
	
	@RequestMapping("/sentence")
	public String ajaxSentence(){
		return "sentence";
	}
}
