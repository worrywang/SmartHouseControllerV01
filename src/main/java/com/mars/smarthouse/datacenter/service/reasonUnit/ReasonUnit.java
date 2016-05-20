package com.mars.smarthouse.datacenter.service.reasonUnit;

import com.mars.smarthouse.bean.iocd.Device;

import java.util.List;

/**
 * Created by ouweilai on 2016/1/13.
 */
public interface ReasonUnit {
    public UnitReasonResult activating(List<Device> machineList);
}
