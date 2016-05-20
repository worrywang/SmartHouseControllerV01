package com.mars.smarthouse.datacenter.stateAnnotator;

import com.mars.smarthouse.constant.Lexicon;
/**
 * Created by ouweilai on 2016/1/19.
 */
public class PM25SensorStateAnnotator implements IStateAnnotator {
    @Override
    public String getState(Object object) {
        double value = Double.valueOf(object.toString());
        if (0.0 <= value && value < 10.0) {
            return Lexicon.low;
        }
        if (10.0 <= value && value <= 25.0) {
            return Lexicon.moderation;
        }
        if (25.0 < value && value <= 35.0) {
            return Lexicon.high;
        }
        if (35.0 < value) {
            return Lexicon.veryHigh;
        }
        return null;
    }
}
