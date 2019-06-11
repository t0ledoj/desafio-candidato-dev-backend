package com.srmasset.thcepdetails.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srmasset.thcepdetails.services.CepService;

@Controller
public class CepController {
	
	private final CepService cepService;
	@Autowired
	CepController (CepService cepService){ this.cepService = cepService; }
	
	@RequestMapping(value="/consultar_cep/{cep}", method=RequestMethod.GET)
	@ResponseBody
	public List<Cep> findDetail(@PathVariable String cep){
		return cepService.getAddressByCep(cep);
	}
	
	@RequestMapping(value = "/consultar_ceps", method = RequestMethod.POST)
	@ResponseBody
	public List<Cep> findDetails(@RequestParam("cep") List<String> cep) {
		return cepService.getAddressByCeps(cep);
	}
}
