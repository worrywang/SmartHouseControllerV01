
package com.mars.smarthouse.bean.iocd;


import java.util.List;

public class Capability
{
   private List<ControlCapability> controlCapability;
   private List<CommunicationCapability> communicationCapability;
   private List<MeasurementCapability> measurementCapability;

   /**
    @roseuid 569366450170
    */
   public Capability()
   {

   }

   /**
    Access method for the controlCapability property.

    @return   the current value of the controlCapability property
    */
   public List<ControlCapability> getControlCapability()
   {
      return controlCapability;
   }

   /**
    Sets the value of the controlCapability property.

    @param aControlCapability the new value of the controlCapability property
    */
   public void setControlCapability(List<ControlCapability> aControlCapability)
   {
      controlCapability = aControlCapability;
   }

   /**
    Access method for the communicationCapability property.

    @return   the current value of the communicationCapability property
    */
   public List<CommunicationCapability> getCommunicationCapability()
   {
      return communicationCapability;
   }

   /**
    Sets the value of the communicationCapability property.

    @param aCommunicationCapability the new value of the communicationCapability property
    */
   public void setCommunicationCapability(List<CommunicationCapability> aCommunicationCapability)
   {
      communicationCapability = aCommunicationCapability;
   }

   /**
    Access method for the measurementCapability property.

    @return   the current value of the measurementCapability property
    */
   public List<MeasurementCapability> getMeasurementCapability()
   {
      return measurementCapability;
   }

   /**
    Sets the value of the measurementCapability property.

    @param aMeasurementCapability the new value of the measurementCapability property
    */
   public void setMeasurementCapability(List<MeasurementCapability> aMeasurementCapability)
   {
      measurementCapability = aMeasurementCapability;
   }
}
