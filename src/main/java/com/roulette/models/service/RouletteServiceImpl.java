package com.roulette.models.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.roulette.models.dao.IBetDao;
import com.roulette.models.dao.IResultDao;
import com.roulette.models.dao.IRouletteDao;
import com.roulette.models.entity.Bet;
import com.roulette.models.entity.Roulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouletteServiceImpl implements IRouletteService {

    @Autowired
	private IRouletteDao rouletteDao;
	
	@Autowired
	private IBetDao betDao;

	@Autowired
	private IResultDao resultDao;
    
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


	@Transactional
	@Override
	public List<Bet> closeRoulette(Long rouletteId) {
		rouletteDao.changeStateRoulette(rouletteId, "close");	


		Random random = new Random(System.currentTimeMillis());		
		Long randomNumberResult =  (long) random.nextInt(36);		
		
		String color = "red";


		if(randomNumberResult % 2 == 0){
			color = "black";
			
		}
		Date resultDate = new Date();
		
		

		resultDao.savedResultsRoulette(rouletteId, randomNumberResult, color,  resultDate);		

		return betDao.getAllBetsByIdRoulette(rouletteId);

	}




    @Override
	public List<Roulette> findAllRoulettes() {
		return rouletteDao.findAllRoulettes();
	}
}