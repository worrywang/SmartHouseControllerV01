package com.mars.smarthouse.datacenter.stateAnnotator;

import com.mars.smarthouse.constant.Lexicon;
/**
 * Created by ouweilai on 2016/1/19.
 */
public class VocSensorStateAnnotator implements IStateAnnotator {
    @Override
    public String getState(Object object) {
        double value = Double.valueOf(object.toString());
        if (value >= 0.0 && value < 0.2) {
            return Lexicon.low;
        }
        if (0.2 <= value && value < 0.4) {
            return Lexicon.moderation;
        }
        if (0.4 <= value) {
            return Lexicon.high;
        }
        return null;
    }
}
