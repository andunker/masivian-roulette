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

	private Long roulette_id;

	private Long result_bet_number;

	private String result_bet_color;

	private Long round_id;

	@Column(name = "result_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoulette_id() {
		return roulette_id;
	}

	public void setRoulette_id(Long roulette_id) {
		this.roulette_id = roulette_id;
	}

	public Long getResult_bet_number() {
		return result_bet_number;
	}

	public void setResult_bet_number(Long result_bet_number) {
		this.result_bet_number = result_bet_number;
	}

	public String getResult_bet_color() {
		return result_bet_color;
	}

	public void setResult_bet_color(String result_bet_color) {
		this.result_bet_color = result_bet_color;
	}

	public Long getRound_id() {
		return round_id;
	}

	public void setRound_id(Long round_id) {
		this.round_id = round_id;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
