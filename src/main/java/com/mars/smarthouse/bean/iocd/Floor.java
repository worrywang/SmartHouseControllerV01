

package com.mars.smarthouse.bean.iocd;


public class Floor 
{
   private String floorID;
   private Room room;
   
   /**
   @roseuid 5693601E0392
    */
   public Floor() 
   {
    
   }
   
   /**
   Access method for the floorID property.
   
   @return   the current value of the floorID property
    */
   public String getFloorID() 
   {
      return floorID;
   }
   
   /**
   Sets the value of the floorID property.
   
   @param aFloorID the new value of the floorID property
    */
   public void setFloorID(String aFloorID) 
   {
      floorID = aFloorID;
   }
   
   /**
   Access method for the room property.
   
   @return   the current value of the room property
    */
   public Room getRoom() 
   {
      return room;
   }
   
   /**
   Sets the value of the room property.
   
   @param aRoom the new value of the room property
    */
   public void setRoom(Room aRoom) 
   {
      room = aRoom;
   }
}
