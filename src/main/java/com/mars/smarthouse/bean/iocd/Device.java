package com.mars.smarthouse.bean.iocd;

import com.mars.smarthouse.constant.RelevantResource;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Device {
	private String id;
	private String name;
	private RelevantResource.DeviceType type;
	private Deployment deployment;
	private Output outputData;
	private Input inputData;
	private Capability capability;

	/**
	 @roseuid 56935CD00353
	 */
	public Device()
	{

	}

	public Capability getCapability() {
		return capability;
	}

	public void setCapability(Capability capability) {
		this.capability = capability;
	}

	public Deployment getDeployment() {
		return deployment;
	}

	public void setDeployment(Deployment deployment) {
		this.deployment = deployment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Input getInputData() {
		return inputData;
	}

	public void setInputData(Input inputData) {
		this.inputData = inputData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Output getOutputData() {
		return outputData;
	}

	public void setOutputData(Output outputData) {
		this.outputData = outputData;
	}

	public RelevantResource.DeviceType getType() {
		return type;
	}

	public void setType(RelevantResource.DeviceType type) {
		this.type = type;
	}
}
