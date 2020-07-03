package com.roulette.controllers;

import java.util.List;

import com.roulette.models.entity.Bet;
import com.roulette.models.entity.Roulette;
import com.roulette.models.service.IRouletteService;
import com.roulette.view_models.ViewBetModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@PutMapping("/roulette/open/{id}")
	public String openRoulette(@PathVariable Long id) {

		try {
			String response = rouletteService.openRoulette(id);
			return response;

		} catch (Exception e) {
			System.out.println(e);
			return "Roulette out of order";
		}
	}

	@PostMapping("/bet") 
	public String createBet(@RequestBody ViewBetModel viewBetModel, @RequestHeader(value = "User") Long userId) {

		try {
			 String response = rouletteService.createBet(viewBetModel.getRouletteId(), userId, viewBetModel.getBetColor(),
					viewBetModel.getBetNumber(), viewBetModel.getBetValue());
			return response;

		} catch (Exception e) {
			System.out.println(e);
			return "I don't know how to bet";
		}

	}	

	@GetMapping("roulette/close/{id}")
	public List<Bet> closeRoulette(@PathVariable Long id) {

		try {
			
			return rouletteService.closeRoulette(id);

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@GetMapping("/roulette")
	public List<Roulette> findAllRoulettes() {

		try {
			return rouletteService.findAllRoulettes();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}