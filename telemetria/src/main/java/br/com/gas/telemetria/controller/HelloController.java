package br.com.gas.telemetria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Olá, bem-vindo ao meu projeto final da Sensedia: TELEMETRIA";
	}
}
