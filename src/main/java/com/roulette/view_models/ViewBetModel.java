package com.roulette.view_models;

public class ViewBetModel {

    private Long rouletteId;

    private String betColor;

    private Long betNumber;

    private Double betValue;

    public Long getRouletteId() {
        return rouletteId;
    }

    public Double getBetValue() {
        return betValue;
    }

    public void setBetValue(Double betValue) {
        this.betValue = betValue;
    }

    public Long getBetNumber() {
        return betNumber;
    }

    public void setBetNumber(Long betNumber) {
        this.betNumber = betNumber;
    }

    public String getBetColor() {
        return betColor;
    }

    public void setBetColor(String betColor) {
        this.betColor = betColor;
    }

    public void setRouletteId(Long rouletteId) {
        this.rouletteId = rouletteId;
    }


}