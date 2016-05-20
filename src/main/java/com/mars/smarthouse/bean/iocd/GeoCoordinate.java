
package com.mars.smarthouse.bean.iocd;


public class GeoCoordinate 
{
   private double longitude;
   private double latitude;
   private double altitude;
   
   /**
   @roseuid 5693601E017E
    */
   public GeoCoordinate() 
   {
    
   }
   
   /**
   Access method for the longitude property.
   
   @return   the current value of the longitude property
    */
   public double getLongitude() 
   {
      return longitude;
   }
   
   /**
   Sets the value of the longitude property.
   
   @param aLongitude the new value of the longitude property
    */
   public void setLongitude(double aLongitude) 
   {
      longitude = aLongitude;
   }
   
   /**
   Access method for the latitude property.
   
   @return   the current value of the latitude property
    */
   public double getLatitude() 
   {
      return latitude;
   }
   
   /**
   Sets the value of the latitude property.
   
   @param aLatitude the new value of the latitude property
    */
   public void setLatitude(double aLatitude) 
   {
      latitude = aLatitude;
   }
   
   /**
   Access method for the altitude property.
   
   @return   the current value of the altitude property
    */
   public double getAltitude() 
   {
      return altitude;
   }
   
   /**
   Sets the value of the altitude property.
   
   @param aAltitude the new value of the altitude property
    */
   public void setAltitude(double aAltitude) 
   {
      altitude = aAltitude;
   }
}
