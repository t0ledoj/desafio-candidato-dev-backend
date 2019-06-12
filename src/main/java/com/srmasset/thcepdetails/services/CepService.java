package com.srmasset.thcepdetails.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.srmasset.thcepdetails.rest.Cep;

@Service
public class CepService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Cacheable("cepDetails")
	public List<Cep> getDetails(List<String> cepNumberList){
		List<Cep> cepDetails = new ArrayList<>();
		cepNumberList.forEach(cepNumber -> {
			Cep cep = restTemplate.getForObject("https://zuul.trusthub.com.br/orchestrator/v1/obter-endereco-por-cep/"+cepNumber, Cep.class);
			cepDetails.add(cep);
		});
		return cepDetails;
	}
}
