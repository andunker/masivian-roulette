package com.roulette.models.dao;

import java.util.Date;
import java.util.List;

import com.roulette.models.entity.Result;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IResultDao extends JpaRepository<Result, Long> {

    @Modifying
    @Query(value = "insert  into Results (roulette_id ,result_bet_number, result_bet_color, result_date )"
       + "values (:roulette_id,:result_bet_number,:result_bet_color,  :result_date) ", nativeQuery = true)
    
     public List<Result> savedResultsRoulette(@Param("roulette_id") Long roulette_id, @Param("result_bet_number") Long result_bet_number,
     @Param("result_bet_color") String result_bet_color,  @Param("result_date") Date result_date) ;
    
}