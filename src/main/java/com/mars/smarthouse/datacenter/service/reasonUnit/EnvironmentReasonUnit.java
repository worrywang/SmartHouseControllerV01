package com.mars.smarthouse.datacenter.service.reasonUnit;


import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.constant.Lexicon;
import com.mars.smarthouse.datacenter.service.SemanticAnnotator;
import com.mars.smarthouse.utils.ObjectFactory;

import java.util.*;

/**
 * Created by ouweilai on 2016/1/13.
 */
public abstract class EnvironmentReasonUnit implements ReasonUnit {
    protected SemanticAnnotator semanticAnnotator = ObjectFactory.createInstance(SemanticAnnotator.class);
    protected UnitReasonResult unitReasonResult = new UnitReasonResult();

    protected String commonReason(List<Device> deviceList) {
        List<String> stateList = new ArrayList<String>();

        for (Device device : deviceList) {
            if (!stateList.contains(device.getOutputData().getStates().iterator().next().getDescription().trim())) {
                stateList.add(device.getOutputData().getStates().iterator().next().getDescription().trim());
            }
        }
        Map<String, Double> results = new HashMap<String, Double>();
        for (String state : stateList) {
            results.put(state, this.statistics(state, deviceList));
        }
        Map.Entry<String, Double> entry = getMaxStateOfProportion(results);
        unitReasonResult.setWave(getWave(entry.getValue()));
        return entry.getKey().toString();
    }

    private double statistics(final String state, List<Device> deviceList) {
        double result = 0.0;
        int counter = 0;
        for (Device device : deviceList) {
            try {
                if (device.getOutputData().getStates() != null && !device.getOutputData().getStates().isEmpty() && device.getOutputData().getStates().iterator().next().getDescription().trim().equals(state)) {
                    counter++;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        result = ((double) counter / (double) deviceList.size());
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        return Double.valueOf(df.format(result));
    }

    private Map.Entry getMaxStateOfProportion(Map<String, Double> results) {
        Map.Entry<String, Double> resultEntry = null;
        Iterator iterator = results.entrySet().iterator();
        Double max = 0.0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Double temp = (Double) entry.getValue();
            if (max < temp) {
                max = temp;
                resultEntry = entry;
            }
        }
        return resultEntry;
    }

    private String getWave(double maxState) {
        if (maxState > 0.5) {
            return Lexicon.steady;
        }
        return Lexicon.big;
    }

    protected abstract void setComfortableLevel();

}
