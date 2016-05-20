
package com.mars.smarthouse.bean.iocd;


public class Address 
{
   private Continent continent;
   
   /**
   @roseuid 5693601E0215
    */
   public Address() 
   {
    
   }
   
   /**
   Access method for the continent property.
   
   @return   the current value of the continent property
    */
   public Continent getContinent() 
   {
      return continent;
   }
   
   /**
   Sets the value of the continent property.
   
   @param aContinent the new value of the continent property
    */
   public void setContinent(Continent aContinent) 
   {
      continent = aContinent;
   }
}
