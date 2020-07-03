package com.roulette.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bets")
public class Bet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long rouletteId;

	private Long userId;

	private Long roundId;

	private String betColor;

	private Long betNumber;

	private Double betValue;

	@Temporal(TemporalType.TIMESTAMP)
	private Date betDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(Long rouletteId) {
		this.rouletteId = rouletteId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoundId() {
		return roundId;
	}

	public void setRoundId(Long roundId) {
		this.roundId = roundId;
	}

	public String getBetColor() {
		return betColor;
	}

	public void setBetColor(String betColor) {
		this.betColor = betColor;
	}

	public Long getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(Long betNumber) {
		this.betNumber = betNumber;
	}

	public Double getBetValue() {
		return betValue;
	}

	public void setBetValue(Double betValue) {
		this.betValue = betValue;
	}

	public Date getBetDate() {
		return betDate;
	}

	public void setBetDate(Date betDate) {
		this.betDate = betDate;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
