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

    private Long roulette_id;

    private Long user_id;

    private Long round_id;

    private String bet_color;

    private Long bet_number;

    private Double bet_value;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bet_date;

    public Long getId() {
        return id;
    }

    public Date getBet_date() {
        return bet_date;
    }

    public void setBet_date(Date bet_date) {
        this.bet_date = bet_date;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRound_id() {
        return round_id;
    }

    public void setRound_id(Long round_id) {
        this.round_id = round_id;
    }

    public String getBet_color() {
        return bet_color;
    }

    public void setBet_color(String bet_color) {
        this.bet_color = bet_color;
    }

    public Long getBet_number() {
        return bet_number;
    }

    public void setBet_number(Long bet_number) {
        this.bet_number = bet_number;
    }

    public Double getBet_value() {
        return bet_value;
    }

    public void setBet_value(Double bet_value) {
        this.bet_value = bet_value;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
