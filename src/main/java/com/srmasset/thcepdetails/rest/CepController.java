package com.srmasset.thcepdetails.rest;

import java.util.ArrayList;
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
	CepController (CepService cepService){ 
		this.cepService = cepService; 
	}
	
	@RequestMapping(value="/consultar_cep/{cepNumber}", method=RequestMethod.GET)
	@ResponseBody
	public List<Cep> findDetailByCep(@PathVariable String cepNumber){
		List<String> cepList = new ArrayList<String>();
		cepList.add(cepNumber);
		return cepService.getDetails(cepList);
	}
	
	@RequestMapping(value = "/consultar_ceps", method = RequestMethod.POST)
	@ResponseBody
	public List<Cep> findDetails(@RequestParam("cep") List<String> cep) {
		return cepService.getDetails(cep);
	}
}
