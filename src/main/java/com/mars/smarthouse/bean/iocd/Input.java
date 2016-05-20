

package com.mars.smarthouse.bean.iocd;


import java.util.List;

public class Input
{
   private List<InputItem> inputItemList;
   
   /**
   @roseuid 569361DE036F
    */
   public Input() 
   {
    
   }
   
   /**
   Access method for the inputItemList property.
   
   @return   the current value of the inputItemList property
    */
   public List<InputItem> getInputItemList()
   {
      return inputItemList;
   }
   
   /**
   Sets the value of the inputItemList property.
   
   @param aInputItemList the new value of the inputItemList property
    */
   public void setInputItemList(List<InputItem> aInputItemList) 
   {
      inputItemList = aInputItemList;
   }
}
