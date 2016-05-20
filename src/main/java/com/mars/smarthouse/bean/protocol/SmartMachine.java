package com.mars.smarthouse.bean.protocol;

import com.mars.smarthouse.bean.iocd.Machine;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public class SmartMachine
{
	private List<Machine> machineList;
	private Machine machine;

	/**
	 @roseuid 56949B5A0185
	 */
	public SmartMachine()
	{

	}

	/**
	 Access method for the machineList property.

	 @return   the current value of the machineList property
	 */
	public List<Machine> getMachineList()
	{
		return machineList;
	}

	/**
	 Sets the value of the machineList property.

	 @param aMachineList the new value of the machineList property
	 */
	public void setMachineList(List<Machine> aMachineList)
	{
		machineList = aMachineList;
	}

	/**
	 Access method for the machine property.

	 @return   the current value of the machine property
	 */
	public Machine getMachine()
	{
		return machine;
	}

	/**
	 Sets the value of the machine property.

	 @param aMachine the new value of the machine property
	 */
	public void setMachine(Machine aMachine)
	{
		machine = aMachine;
	}
}
