package mx.com.allianz.ws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {
	
	@RequestMapping("/sumar")
	public int sumar(int a, int b){
		return a + b;
	}
	
}