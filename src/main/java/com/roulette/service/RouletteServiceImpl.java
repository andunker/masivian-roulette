package com.roulette.service;

import java.util.Date;

import com.roulette.dao.IRouletteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouletteServiceImpl implements IRouletteService {

    @Autowired
    private IRouletteDao rouletteDao;
    
    @Transactional
	@Override
	public void createRoulette(Long id) {
		Date date = new Date();
		rouletteDao.createRoulette(id, "close", date);
	}

	@Transactional
	@Override
	public String openRoulette(Long id) {
		int result = rouletteDao.changeStateRoulette(id, "open");
		if(result == 1){
			return "open roulette";
		} else {
			return "roulette does not exist";
		}
		
	}
    
}