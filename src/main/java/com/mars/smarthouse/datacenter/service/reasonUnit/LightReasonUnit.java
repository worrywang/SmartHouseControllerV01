package com.mars.smarthouse.datacenter.service.reasonUnit;

import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.constant.Lexicon;
import com.mars.smarthouse.constant.Setting;

import java.util.List;

/**
 * Created by ouweilai on 2016/1/13.
 */
public class LightReasonUnit extends EnvironmentReasonUnit {
    @Override
    public UnitReasonResult activating(List<Device> machineList) {
        String result = this.commonReason(machineList);
        String state = semanticAnnotator.LightAnnotator(result);
        unitReasonResult.setState(state);
        setComfortableLevel();
        return unitReasonResult;

    }

    @Override
    protected void setComfortableLevel() {
        String comfortable = unitReasonResult.getState();
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        if (comfortable.equals(Lexicon.very_glare)) {
            unitReasonResult.setLevel(Lexicon.comfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Setting.ComfortableLevel_value + Math.random() * 30.0)));
        }

        if (comfortable.equals(Lexicon.dim)) {
            unitReasonResult.setLevel(Lexicon.uncomfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(df.format(Setting.ComfortableLevel_value + Math.random() * 30.0)));
        }

        //还没有考虑当前时间
        //晚上
        if (comfortable.equals(Lexicon.dark)) {
            unitReasonResult.setLevel(Lexicon.uncomfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(Setting.ComfortableLevel_value + Math.random() * 30.0));
        }

        //白天
        if (comfortable.equals(Lexicon.normal) || comfortable.equals(Lexicon.glare)) {
            unitReasonResult.setLevel(Lexicon.comfort);
            unitReasonResult.setComfortableLevel(Double.valueOf(Math.random() * 40.0));
        }
    }
}
