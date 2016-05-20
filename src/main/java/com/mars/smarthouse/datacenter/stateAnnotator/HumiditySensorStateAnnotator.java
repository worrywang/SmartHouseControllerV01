package com.mars.smarthouse.datacenter.stateAnnotator;

import com.mars.smarthouse.constant.Lexicon;

/**
 * Created by ouweilai on 2016/1/19.
 */
public class HumiditySensorStateAnnotator implements IStateAnnotator {
    @Override
    public String getState(Object object) {
        double value = Double.valueOf(object.toString());
        if (value >= 0.0 && value < 0.2) {
            return Lexicon.veryLow;
        }
        if (value >= 0.2 && value < 0.4) {
            return Lexicon.low;
        }
        if (0.4 <= value && value < 0.6) {
            return Lexicon.moderation;
        }
        if (0.6 <= value && value < 0.8) {
            return Lexicon.high;
        }
        if (0.8 <= value && value <= 1.0) {
            return Lexicon.veryHigh;
        }
        return null;
    }
}
