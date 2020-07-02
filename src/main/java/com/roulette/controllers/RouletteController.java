package com.roulette.controllers;

import com.roulette.service.IRouletteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RouletteController {

    @Autowired
	private IRouletteService rouletteService;

	@GetMapping("/ping")
	public String index() {
		return "pong";
	}

	@PostMapping("/roulette/{id}")
	public String createRoulette(@PathVariable Long id) {

		try {
			rouletteService.createRoulette(id);
			return "success";

		} catch (Exception e) {
			System.out.println(e);
			return "failed";
		}

	}
    
}