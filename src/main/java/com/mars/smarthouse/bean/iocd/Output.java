

package com.mars.smarthouse.bean.iocd;


import java.util.List;

public class Output
{
   private List<StateItem> states;
   private List<ObservationItem> observations;
   private List<CommandItem> commands;
   
   /**
   @roseuid 569361DE03CC
    */
   public Output() 
   {
    
   }
   
   /**
   Access method for the states property.
   
   @return   the current value of the states property
    */
   public List<StateItem> getStates() 
   {
      return states;
   }
   
   /**
   Sets the value of the states property.
   
   @param aStates the new value of the states property
    */
   public void setStates(List<StateItem> aStates)
   {
      states = aStates;
   }
   
   /**
   Access method for the observations property.
   
   @return   the current value of the observations property
    */
   public List<ObservationItem> getObservations() 
   {
      return observations;
   }
   
   /**
   Sets the value of the observations property.
   
   @param aObservations the new value of the observations property
    */
   public void setObservations(List<ObservationItem> aObservations) 
   {
      observations = aObservations;
   }
   
   /**
   Access method for the commands property.
   
   @return   the current value of the commands property
    */
   public List<CommandItem> getCommands() 
   {
      return commands;
   }
   
   /**
   Sets the value of the commands property.
   
   @param aCommands the new value of the commands property
    */
   public void setCommands(List<CommandItem> aCommands) 
   {
      commands = aCommands;
   }
}
