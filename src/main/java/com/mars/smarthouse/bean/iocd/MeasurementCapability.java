

package com.mars.smarthouse.bean.iocd;


public class MeasurementCapability 
{
   private String name;
   private InputItem inputItem;
   
   /**
   @roseuid 56936D4C02A0
    */
   public MeasurementCapability() 
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
   Access method for the inputItem property.
   
   @return   the current value of the inputItem property
    */
   public InputItem getInputItem() 
   {
      return inputItem;
   }
   
   /**
   Sets the value of the inputItem property.
   
   @param aInputItem the new value of the inputItem property
    */
   public void setInputItem(InputItem aInputItem) 
   {
      inputItem = aInputItem;
   }
}
