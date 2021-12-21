package com.web.app.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.app.models.Calculadora;
import com.web.app.services.CalculadoraServices;

@Controller
@RequestMapping(path = "/app")

public class CalculadoraController {

	private CalculadoraServices calculadoraServices = new CalculadoraServices();

	@GetMapping(path = { "/", "", "/lectura" })
	public String lectura(Model model) {
		model.addAttribute("calculadora",new Calculadora());
		return "Lectura";
	}

	@PostMapping(path = { "/resultados" })
	public String resultados(@Valid Calculadora calculadora, BindingResult result,
			@RequestParam String metodo, Model model) {
		
		if (result.hasErrors()) {
			
			return "Lectura";
		} 
		
		switch (metodo) {
		case "Suma":
			model.addAttribute("resultado",
					calculadoraServices.suma(calculadora.getNumero1(), calculadora.getNumero2()));
			break;
		case "Resta":
			model.addAttribute("resultado",
					calculadoraServices.resta(calculadora.getNumero1(), calculadora.getNumero2()));
			break;
		case "Division":
			model.addAttribute("resultado",
					calculadoraServices.division(calculadora.getNumero1(), calculadora.getNumero2()));
			break;
		case "Multiplicacion":
			model.addAttribute("resultado",
					calculadoraServices.multiplicacion(calculadora.getNumero1(), calculadora.getNumero2()));
			break;
		}

		return "Resultados";
	}

}
