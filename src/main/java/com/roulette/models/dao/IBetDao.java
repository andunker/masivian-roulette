package com.roulette.models.dao;

import java.util.Date;
import java.util.List;

import com.roulette.models.entity.Bet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBetDao extends JpaRepository<Bet, Long> {

    @Modifying
	@Query(value = "insert  into Bets (roulette_id, user_id, round_id, bet_color, bet_number, bet_value, bet_date ) "
			+ "values (:roulette_id,:user_id,:round_id,:bet_color,:bet_number,:bet_value,:bet_date) ", nativeQuery = true)
	public void createBet(@Param("roulette_id") Long roulette_id, @Param("user_id") Long user_id,
			@Param("round_id") Long round_id, @Param("bet_color") String bet_color,
			@Param("bet_number") Long bet_number, @Param("bet_value") Double bet_value,
			@Param("bet_date") Date bet_date);

	@Modifying
	@Query(value = "select * from Bets where roulette_id = :roulette_id", nativeQuery = true)
	public List<Bet> getAllBetsByIdRoulette(@Param("roulette_id") Long roulette_id);
    
}