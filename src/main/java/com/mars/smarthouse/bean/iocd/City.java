

package com.mars.smarthouse.bean.iocd;


public class City 
{
   private String cityID;
   private Street street;
   
   /**
   @roseuid 5693601E02CF
    */
   public City() 
   {
    
   }
   
   /**
   Access method for the cityID property.
   
   @return   the current value of the cityID property
    */
   public String getCityID() 
   {
      return cityID;
   }
   
   /**
   Sets the value of the cityID property.
   
   @param aCityID the new value of the cityID property
    */
   public void setCityID(String aCityID) 
   {
      cityID = aCityID;
   }
   
   /**
   Access method for the street property.
   
   @return   the current value of the street property
    */
   public Street getStreet() 
   {
      return street;
   }
   
   /**
   Sets the value of the street property.
   
   @param aStreet the new value of the street property
    */
   public void setStreet(Street aStreet) 
   {
      street = aStreet;
   }
}
