

package com.mars.smarthouse.bean.iocd;


public class Nation 
{
   private String nationID;
   private Province province;
   
   /**
   @roseuid 5693601E0270
    */
   public Nation() 
   {
    
   }
   
   /**
   Access method for the nationID property.
   
   @return   the current value of the nationID property
    */
   public String getNationID() 
   {
      return nationID;
   }
   
   /**
   Sets the value of the nationID property.
   
   @param aNationID the new value of the nationID property
    */
   public void setNationID(String aNationID) 
   {
      nationID = aNationID;
   }
   
   /**
   Access method for the province property.
   
   @return   the current value of the province property
    */
   public Province getProvince() 
   {
      return province;
   }
   
   /**
   Sets the value of the province property.
   
   @param aProvince the new value of the province property
    */
   public void setProvince(Province aProvince) 
   {
      province = aProvince;
   }
}
