

package com.mars.smarthouse.bean.iocd;


public class Location 
{
   private RelativeLocation relativeLocation;
   private AbsoluteLocation absoluteLocation;
   
   /**
   @roseuid 5693601E01BE
    */
   public Location() 
   {
    
   }
   
   /**
   Access method for the relativeLocation property.
   
   @return   the current value of the relativeLocation property
    */
   public RelativeLocation getRelativeLocation() 
   {
      return relativeLocation;
   }
   
   /**
   Sets the value of the relativeLocation property.
   
   @param aRelativeLocation the new value of the relativeLocation property
    */
   public void setRelativeLocation(RelativeLocation aRelativeLocation) 
   {
      relativeLocation = aRelativeLocation;
   }
   
   /**
   Access method for the absoluteLocation property.
   
   @return   the current value of the absoluteLocation property
    */
   public AbsoluteLocation getAbsoluteLocation() 
   {
      return absoluteLocation;
   }
   
   /**
   Sets the value of the absoluteLocation property.
   
   @param aAbsoluteLocation the new value of the absoluteLocation property
    */
   public void setAbsoluteLocation(AbsoluteLocation aAbsoluteLocation) 
   {
      absoluteLocation = aAbsoluteLocation;
   }
}
