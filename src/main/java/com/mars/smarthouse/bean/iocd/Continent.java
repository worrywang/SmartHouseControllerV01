

package com.mars.smarthouse.bean.iocd;


public class Continent 
{
   private String continentID;
   private Nation nation;
   
   /**
   @roseuid 5693601E0240
    */
   public Continent() 
   {
    
   }
   
   /**
   Access method for the continentID property.
   
   @return   the current value of the continentID property
    */
   public String getContinentID() 
   {
      return continentID;
   }
   
   /**
   Sets the value of the continentID property.
   
   @param aContinentID the new value of the continentID property
    */
   public void setContinentID(String aContinentID) 
   {
      continentID = aContinentID;
   }
   
   /**
   Access method for the nation property.
   
   @return   the current value of the nation property
    */
   public Nation getNation() 
   {
      return nation;
   }
   
   /**
   Sets the value of the nation property.
   
   @param aNation the new value of the nation property
    */
   public void setNation(Nation aNation) 
   {
      nation = aNation;
   }
}
