package com.xl.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SentenceController {
	
	/*@Autowired
	DiscoveryClient client;*/
	
	@Autowired 
	LoadBalancerClient loadBalancer;
	
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("SUBJECT") + " " + getWord("VERB") + " " + getWord("ARTICLE") + " "
				+ getWord("ADJECTIVE") + " " + getWord("NOUN") + ".";
	}

/*	public String getWord(String service) {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}*/
	
	public String getWord(String service) {
		ServiceInstance instance = loadBalancer.choose(service);
		if (instance != null){
			URI uri = instance.getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}		
		return null;
	}

}
