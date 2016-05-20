package com.mars.smarthouse.datacenter.service.reasonUnit;

/**
 * Created by ouweilai on 2016/1/14.
 */
public class UnitReasonResult {
    private String state = null;
    private String wave = null;
    private double comfortableLevel;
    private String level = null;

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }

    public double getComfortableLevel() {
        return comfortableLevel;
    }

    public void setComfortableLevel(double comfortableLevel) {
        this.comfortableLevel = comfortableLevel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
