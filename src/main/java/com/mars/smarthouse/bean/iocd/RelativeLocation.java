

package com.mars.smarthouse.bean.iocd;


public class RelativeLocation 
{
   private RelativeOffset relativeOffset;
   private ReferencePoint referencePoint;
   
   /**
   @roseuid 5693601E0154
    */
   public RelativeLocation() 
   {
    
   }
   
   /**
   Access method for the relativeOffset property.
   
   @return   the current value of the relativeOffset property
    */
   public RelativeOffset getRelativeOffset() 
   {
      return relativeOffset;
   }
   
   /**
   Sets the value of the relativeOffset property.
   
   @param aRelativeOffset the new value of the relativeOffset property
    */
   public void setRelativeOffset(RelativeOffset aRelativeOffset) 
   {
      relativeOffset = aRelativeOffset;
   }
   
   /**
   Access method for the referencePoint property.
   
   @return   the current value of the referencePoint property
    */
   public ReferencePoint getReferencePoint() 
   {
      return referencePoint;
   }
   
   /**
   Sets the value of the referencePoint property.
   
   @param aReferencePoint the new value of the referencePoint property
    */
   public void setReferencePoint(ReferencePoint aReferencePoint) 
   {
      referencePoint = aReferencePoint;
   }
}
