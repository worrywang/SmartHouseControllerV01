

package com.mars.smarthouse.bean.iocd;


public class Province 
{
   private String provinceID;
   private City city;
   
   /**
   @roseuid 5693601E029F
    */
   public Province() 
   {
    
   }
   
   /**
   Access method for the provinceID property.
   
   @return   the current value of the provinceID property
    */
   public String getProvinceID() 
   {
      return provinceID;
   }
   
   /**
   Sets the value of the provinceID property.
   
   @param aProvinceID the new value of the provinceID property
    */
   public void setProvinceID(String aProvinceID) 
   {
      provinceID = aProvinceID;
   }
   
   /**
   Access method for the city property.
   
   @return   the current value of the city property
    */
   public City getCity() 
   {
      return city;
   }
   
   /**
   Sets the value of the city property.
   
   @param aCity the new value of the city property
    */
   public void setCity(City aCity) 
   {
      city = aCity;
   }
}
