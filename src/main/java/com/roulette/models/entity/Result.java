package com.roulette.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "results")
public class Result implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long rouletteId;

	private Long resultBetNumber;

	private String resultBetColor;

	private Long roundId;

	@Column(name = "result_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

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

	public Long getResultBetNumber() {
		return resultBetNumber;
	}

	public void setResultBetNumber(Long resultBetNumber) {
		this.resultBetNumber = resultBetNumber;
	}

	public String getResultBetColor() {
		return resultBetColor;
	}

	public void setResultBetColor(String resultBetColor) {
		this.resultBetColor = resultBetColor;
	}

	public Long getRoundId() {
		return roundId;
	}

	public void setRoundId(Long roundId) {
		this.roundId = roundId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
