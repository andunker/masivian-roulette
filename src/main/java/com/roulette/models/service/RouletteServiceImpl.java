package com.roulette.models.service;

import java.util.Date;

import com.roulette.models.dao.IBetDao;
import com.roulette.models.dao.IRouletteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouletteServiceImpl implements IRouletteService {

    @Autowired
	private IRouletteDao rouletteDao;
	
	@Autowired
	private IBetDao betDao;
    
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

	@Transactional
	@Override
	public String createBet(Long rouletteId, Long userId, String betColor,  Long betNumber,
			 Double betValue) {
		final String state = rouletteDao.findRoulettesById(rouletteId).getState();

		if (state.equals("open") && betNumber > 0 && betNumber < 36 && betValue > 0 && betValue < 10000
				|| (betColor.equals("black") || betColor.equals("red"))) {
			final Date betDate = new Date();
			final long roundId = 12; // quitar
			betDao.createBet(rouletteId, userId, roundId, betColor, betNumber, betValue, betDate);
			return "success";
		} else {
			return "Closed roulette";
		}

	}
    
}