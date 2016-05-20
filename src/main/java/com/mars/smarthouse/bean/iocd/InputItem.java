

package com.mars.smarthouse.bean.iocd;


public class InputItem 
{
   private String name;
   private CommandItem commandItem;
   
   /**
   @roseuid 569361DE02DE
    */
   public InputItem() 
   {
    
   }
   
   /**
   Access method for the name property.
   
   @return   the current value of the name property
    */
   public String getName() 
   {
      return name;
   }
   
   /**
   Sets the value of the name property.
   
   @param aName the new value of the name property
    */
   public void setName(String aName) 
   {
      name = aName;
   }
   
   /**
   Access method for the commandItem property.
   
   @return   the current value of the commandItem property
    */
   public CommandItem getCommandItem() 
   {
      return commandItem;
   }
   
   /**
   Sets the value of the commandItem property.
   
   @param aCommandItem the new value of the commandItem property
    */
   public void setCommandItem(CommandItem aCommandItem) 
   {
      commandItem = aCommandItem;
   }
}
