

package com.mars.smarthouse.bean.iocd;


public class Street 
{
   private String streetID;
   private Building building;
   
   /**
   @roseuid 5693601E0303
    */
   public Street() 
   {
    
   }
   
   /**
   Access method for the streetID property.
   
   @return   the current value of the streetID property
    */
   public String getStreetID() 
   {
      return streetID;
   }
   
   /**
   Sets the value of the streetID property.
   
   @param aStreetID the new value of the streetID property
    */
   public void setStreetID(String aStreetID) 
   {
      streetID = aStreetID;
   }
   
   /**
   Access method for the building property.
   
   @return   the current value of the building property
    */
   public Building getBuilding() 
   {
      return building;
   }
   
   /**
   Sets the value of the building property.
   
   @param aBuilding the new value of the building property
    */
   public void setBuilding(Building aBuilding) 
   {
      building = aBuilding;
   }
}
