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
	private List<Cep> ceps;
	private RestTemplate restTemplate = new RestTemplate();
	private Cep cep;
	@Autowired
	CepService(){}
	
	@Cacheable("ceps")
	public List<Cep> getAddressByCep(String value) {
		ceps = new ArrayList<>();
		getAddress(value);
		return ceps;
	}
	@Cacheable("ceps")
	public List<Cep> getAddressByCeps(List<String> cepsList) {
		ceps = new ArrayList<>();
		cepsList.forEach(cepNumber -> getAddress(cepNumber));
		return ceps;
	}
	
	public void getAddress(String value) {
		cep = restTemplate.getForObject("https://zuul.trusthub.com.br/orchestrator/v1/obter-endereco-por-cep/"+value, Cep.class);
		ceps.add(cep);
	}
}
