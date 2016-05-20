package com.mars.smarthouse.datacenter.stateAnnotator;

import com.mars.smarthouse.constant.Lexicon;
/**
 * Created by ouweilai on 2016/1/19.
 */
public class TemperatureSensorStateAnnotator implements IStateAnnotator {
    @Override
    public String getState(Object object) {
        double value = Double.valueOf(object.toString());
        if (value <= 0.0) {
            return Lexicon.veryLow;
        }
        if (0.0 < value && value <= 15.0) {
            return Lexicon.low;
        }

        if (15.0 < value && value <= 27.0) {
            return Lexicon.moderation;
        }

        if (27.0 < value && value <= 35.0) {
            return Lexicon.high;
        }

        if (value > 35.0) {
            return Lexicon.veryHigh;
        }
        return null;
    }
}
