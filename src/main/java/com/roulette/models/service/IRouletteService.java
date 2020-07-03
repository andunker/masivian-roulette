package com.roulette.models.service;

import java.util.List;

import com.roulette.models.entity.Roulette;

public interface IRouletteService {

    public void createRoulette(Long id);

    public String openRoulette(Long id);

    public String createBet(Long rouletteId, Long userId, 
    String betColor, Long betNumber, Double betValue);
    


    public List<Roulette> findAllRoulettes();
    
}