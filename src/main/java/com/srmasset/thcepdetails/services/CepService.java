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
	
	public Cep getAddressByCep(String value) {
		Cep cep = getAddress(value);
		return cep;
	}

	public List<Cep> getAddressesByCep(List<String> cepsList) {
		List<Cep> ceps = new ArrayList<>();
		cepsList.forEach(cepNumber -> ceps.add(getAddress(cepNumber)));
		return ceps;
	}
	
	@Cacheable("ceps")
	public Cep getAddress(String value) {
		Cep cep = restTemplate.getForObject("https://zuul.trusthub.com.br/orchestrator/v1/obter-endereco-por-cep/"+value, Cep.class);
		return cep;
	}
}
