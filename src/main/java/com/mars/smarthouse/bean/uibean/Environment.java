package com.mars.smarthouse.bean.uibean;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Environment {
	private String name;
	private String state;
	private String wave;
	private double comfortableLevel;
	private String level;

	/**
	 @roseuid 56936D4C0000
	 */
	public Environment()
	{

	}

	/**
	 Access method for the name property.

	 @return   the current value of the name property
	 */
	public String getName()
	{
		return name;
	}

	/**
	 Sets the value of the name property.

	 @param aName the new value of the name property
	 */
	public void setName(String aName)
	{
		name = aName;
	}

	/**
	 Access method for the state property.

	 @return   the current value of the state property
	 */
	public String getState()
	{
		return state;
	}

	/**
	 Sets the value of the state property.

	 @param aState the new value of the state property
	 */
	public void setState(String aState)
	{
		state = aState;
	}

	/**
	 Access method for the wave property.

	 @return   the current value of the wave property
	 */
	public String getWave()
	{
		return wave;
	}

	/**
	 Sets the value of the wave property.

	 @param aWave the new value of the wave property
	 */
	public void setWave(String aWave)
	{
		wave = aWave;
	}

	/**
	 Access method for the comfortableLevel property.

	 @return   the current value of the comfortableLevel property
	 */
	public double getComfortableLevel()
	{
		return comfortableLevel;
	}

	/**
	 Sets the value of the comfortableLevel property.

	 @param aComfortableLevel the new value of the comfortableLevel property
	 */
	public void setComfortableLevel(double aComfortableLevel)
	{
		comfortableLevel = aComfortableLevel;
	}

	/**
	 Access method for the level property.

	 @return   the current value of the level property
	 */
	public String getLevel()
	{
		return level;
	}

	/**
	 Sets the value of the level property.

	 @param aLevel the new value of the level property
	 */
	public void setLevel(String aLevel)
	{
		level = aLevel;
	}
}
