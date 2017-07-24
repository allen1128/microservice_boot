package com.xl.demo.dao;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

public abstract class WordDaoImpl {

	@Autowired 
	LoadBalancerClient loadBalancer;
	abstract public String getPartOfSpeech();
	
	final String NOUN = "NOUN";
	final String VERB = "VERB";
	final String SUBJECT = "SUBJECT";
	final String ADJECTIVE = "ADJECTIVE";
	final String ARTICLE = "ARTICLE";
		
	public String getWord() {
		ServiceInstance instance = loadBalancer.choose(getPartOfSpeech());
		if (instance != null){
			URI uri = instance.getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}		
		return null;
	}	
}
