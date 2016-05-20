
package com.mars.smarthouse.bean.iocd;


public class Building 
{
   private String buildingID;
   private Floor floor;
   
   /**
   @roseuid 5693601E0343
    */
   public Building() 
   {
    
   }
   
   /**
   Access method for the buildingID property.
   
   @return   the current value of the buildingID property
    */
   public String getBuildingID() 
   {
      return buildingID;
   }
   
   /**
   Sets the value of the buildingID property.
   
   @param aBuildingID the new value of the buildingID property
    */
   public void setBuildingID(String aBuildingID) 
   {
      buildingID = aBuildingID;
   }
   
   /**
   Access method for the floor property.
   
   @return   the current value of the floor property
    */
   public Floor getFloor() 
   {
      return floor;
   }
   
   /**
   Sets the value of the floor property.
   
   @param aFloor the new value of the floor property
    */
   public void setFloor(Floor aFloor) 
   {
      floor = aFloor;
   }
}
