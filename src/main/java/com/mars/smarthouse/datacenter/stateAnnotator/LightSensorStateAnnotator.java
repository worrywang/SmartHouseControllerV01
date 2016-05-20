package com.mars.smarthouse.datacenter.stateAnnotator;

import com.mars.smarthouse.constant.Lexicon;
/**
 * Created by ouweilai on 2016/1/19.
 */
public class LightSensorStateAnnotator implements IStateAnnotator {
    @Override
    public String getState(Object object) {
        double value = Double.valueOf(object.toString());
        if (0.0 <= value && value < 40.0) {
            return Lexicon.veryLow;
        }
        if (40.0 <= value && value <= 90.0) {
            return Lexicon.low;
        }
        if (90.0 < value && value <= 180.0) {
            return Lexicon.moderation;
        }
        if (180.0 < value && value <= 240.0) {
            return Lexicon.high;
        }
        if (value > 240.0) {
            return Lexicon.veryHigh;
        }
        return null;
    }
}
