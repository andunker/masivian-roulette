package com.roulette.service;

import java.util.Date;

import com.roulette.dao.IRouletteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouletteService implements IRouletteService {

    @Autowired
    private IRouletteDao rouletteDao;
    
    @Transactional
	@Override
	public void createRoulette(Long id) {
		Date date = new Date();
		rouletteDao.createRoulette(id, "close", date);
	}
    
}