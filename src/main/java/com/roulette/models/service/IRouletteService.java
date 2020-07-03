package com.roulette.models.service;

public interface IRouletteService {

    public void createRoulette(Long id);

    public String openRoulette(Long id);

    public String createBet(Long rouletteId, Long userId, 
		String betColor, Long betNumber, Double betValue);
    
}