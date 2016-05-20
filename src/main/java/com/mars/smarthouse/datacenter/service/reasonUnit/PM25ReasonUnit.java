package com.mars.smarthouse.datacenter.service.reasonUnit;

import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.constant.Lexicon;
import com.mars.smarthouse.constant.Setting;

import java.util.List;

/**
 * Created by ouweilai on 2016/1/13.
 */
public class PM25ReasonUnit extends EnvironmentReasonUnit {
    @Override
    public UnitReasonResult activating(List<Device> machineList) {
        String result = this.commonReason(machineList);
        String state = semanticAnnotator.PM25Annotator(result);
        unitReasonResult.setState(state);
        setComfortableLevel();
        return unitReasonResult;
    }

    @Override
    protected void setComfortableLevel() {
        String comfortable = unitReasonResult.getState();
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        if (comfortable.equals(Lexicon.veryHigh)) {
            unitReasonResult.setLevel(Lexicon.warning);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Setting.UncomfortableLevel_value + Math.random() * 30.0)));
        }

        if (comfortable.equals(Lexicon.high)) {
            unitReasonResult.setLevel(Lexicon.uncomfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Setting.ComfortableLevel_value + Math.random() * 30.0)));
        }

        if (comfortable.equals(Lexicon.low)) {
            unitReasonResult.setLevel(Lexicon.comfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Math.random() * 40.0)));
        }
    }
}