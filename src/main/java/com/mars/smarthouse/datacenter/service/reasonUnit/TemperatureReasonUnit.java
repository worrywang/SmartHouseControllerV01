package com.mars.smarthouse.datacenter.service.reasonUnit;

import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.constant.Lexicon;
import com.mars.smarthouse.constant.Setting;


import java.util.List;

/**
 * Created by ouweilai on 2016/1/13.
 */
public class TemperatureReasonUnit extends EnvironmentReasonUnit {
    @Override
    public UnitReasonResult activating(List<Device> machineList) {
        String result = this.commonReason(machineList);
        String state = semanticAnnotator.TemperatureAnnotator(result);
        unitReasonResult.setState(state);
        setComfortableLevel();
        return unitReasonResult;

    }

    @Override
    protected void setComfortableLevel() {
        String comfortable = unitReasonResult.getState();
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        if (comfortable.equals(Lexicon.freezing) || comfortable.equals(Lexicon.very_burning)) {
            unitReasonResult.setLevel(Lexicon.warning);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Setting.UncomfortableLevel_value + Math.random() * 30.0)));
        }

        if (comfortable.equals(Lexicon.cold) || comfortable.equals(Lexicon.burning)) {
            unitReasonResult.setLevel(Lexicon.uncomfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Setting.ComfortableLevel_value + Math.random() * 30.0)));
        }

        if (comfortable.equals(Lexicon.normal)) {
            unitReasonResult.setLevel(Lexicon.comfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format( Math.random() * 40.0)));
        }
    }
}
