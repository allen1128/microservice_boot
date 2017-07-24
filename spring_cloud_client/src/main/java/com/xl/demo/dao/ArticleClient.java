package com.xl.demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xl.demo.domain.Word;

@FeignClient("ARTICLE")
public interface ArticleClient {
	@RequestMapping(method = RequestMethod.GET, value="/")
	public Word getWord();
}
