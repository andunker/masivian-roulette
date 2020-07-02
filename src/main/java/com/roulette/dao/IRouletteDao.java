package com.roulette.dao;

import java.util.Date;

import com.roulette.models.entity.Roulette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRouletteDao extends JpaRepository<Roulette, Long> {

    @Modifying
	@Query(value = "insert  into Roulettes (id ,state, create_at ) values (:id,:state,:create_at) ", nativeQuery = true)
	public void createRoulette(@Param("id") Long id, @Param("state") String state, @Param("create_at") Date create_at);
    
}