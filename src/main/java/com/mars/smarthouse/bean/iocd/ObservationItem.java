

package com.mars.smarthouse.bean.iocd;

import java.util.Date;

public class ObservationItem 
{
   private String name;
   private Object value;
   private String unit;
//   private Date time;
   private String  time;
   /**
   @roseuid 5693664500A0
    */
   public ObservationItem() 
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
   Access method for the value property.
   
   @return   the current value of the value property
    */
   public Object getValue() 
   {
      return value;
   }
   
   /**
   Sets the value of the value property.
   
   @param aValue the new value of the value property
    */
   public void setValue(Object aValue) 
   {
      value = aValue;
   }
   
   /**
   Access method for the unit property.
   
   @return   the current value of the unit property
    */
   public String getUnit() 
   {
      return unit;
   }
   
   /**
   Sets the value of the unit property.
   
   @param aUnit the new value of the unit property
    */
   public void setUnit(String aUnit) 
   {
      unit = aUnit;
   }
//
//   /**
//   Access method for the time property.
//
//   @return   the current value of the time property
//    */
//   public Date getTime()
//   {
//      return time;
//   }
//
//   /**
//   Sets the value of the time property.
//
//   @param aTime the new value of the time property
//    */
//   public void setTime(Date aTime)
//   {
//      time = aTime;
//   }


   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }
}
