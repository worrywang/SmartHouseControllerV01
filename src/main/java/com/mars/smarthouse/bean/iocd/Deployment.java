
package com.mars.smarthouse.bean.iocd;


public class Deployment 
{
   private Location location_;
   private LocationT location;
   /**
   @roseuid 569360480390
    */
   public Deployment() 
   {
    
   }
   
   /**
   Access method for the location_ property.
   
   @return   the current value of the location_ property
    */
   public Location getLocation_()
   {
      return location_;
   }
   
   /**
   Sets the value of the location_ property.
   
   @param aLocation the new value of the location_ property
    */
   public void setLocation_(Location aLocation)
   {
      location_ = aLocation;
   }

   public LocationT getLocation() {
      return location;
   }

   public void setLocation(LocationT location) {
      this.location = location;
   }
}
