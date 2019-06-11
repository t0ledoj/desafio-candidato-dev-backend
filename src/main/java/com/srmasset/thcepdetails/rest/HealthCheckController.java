package com.srmasset.thcepdetails.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HealthCheckController {
	
	@GetMapping("/info")
	@ResponseBody
	public String info() {
		return checkHealth();
	}
	
	public String checkHealth() {
		RestTemplate restTpl = new RestTemplate();
		Status status = restTpl.getForObject("http://localhost:8080/actuator/health", Status.class);
		return status.toString();
	}
}
