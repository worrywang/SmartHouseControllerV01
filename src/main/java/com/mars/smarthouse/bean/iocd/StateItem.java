

package com.mars.smarthouse.bean.iocd;

import java.util.Date;

public class StateItem 
{
   private String name;
   private String description;
//   private String
//   private Date time;
   private String time;
   /**
   @roseuid 56936645004A
    */
   public StateItem() 
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
   Access method for the description property.
   
   @return   the current value of the description property
    */
   public String getDescription() 
   {
      return description;
   }
   
   /**
   Sets the value of the description property.
   
   @param aDescription the new value of the description property
    */
   public void setDescription(String aDescription) 
   {
      description = aDescription;
   }
   
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
