

package com.mars.smarthouse.bean.iocd;


public class Machine 
{
   private String id;
   private String name;
   private String type;
   private Deployment deployment;
   private Output output;
   private Input input;
   private Capability capability;
   
   /**
   @roseuid 56935CD00353
    */
   public Machine() 
   {
    
   }
   
   /**
   Access method for the id property.
   
   @return   the current value of the id property
    */
   public String getId()
   {
      return id;
   }
   
   /**
   Sets the value of the id property.
   
   @param aMachineID the new value of the id property
    */
   public void setId(String aMachineID)
   {
      id = aMachineID;
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
   Access method for the type property.
   
   @return   the current value of the type property
    */
   public String getType() 
   {
      return type;
   }
   
   /**
   Sets the value of the type property.
   
   @param aType the new value of the type property
    */
   public void setType(String aType) 
   {
      type = aType;
   }
   
   /**
   Access method for the deployment property.
   
   @return   the current value of the deployment property
    */
   public Deployment getDeployment() 
   {
      return deployment;
   }
   
   /**
   Sets the value of the deployment property.
   
   @param aDeployment the new value of the deployment property
    */
   public void setDeployment(Deployment aDeployment) 
   {
      deployment = aDeployment;
   }
   
   /**
   Access method for the output property.
   
   @return   the current value of the output property
    */
   public Output getOutput() 
   {
      return output;
   }
   
   /**
   Sets the value of the output property.
   
   @param aOutput the new value of the output property
    */
   public void setOutput(Output aOutput) 
   {
      output = aOutput;
   }
   
   /**
   Access method for the input property.
   
   @return   the current value of the input property
    */
   public Input getInput() 
   {
      return input;
   }
   
   /**
   Sets the value of the input property.
   
   @param aInput the new value of the input property
    */
   public void setInput(Input aInput) 
   {
      input = aInput;
   }
   
   /**
   Access method for the capability property.
   
   @return   the current value of the capability property
    */
   public Capability getCapability() 
   {
      return capability;
   }
   
   /**
   Sets the value of the capability property.
   
   @param aCapability the new value of the capability property
    */
   public void setCapability(Capability aCapability) 
   {
      capability = aCapability;
   }

}
