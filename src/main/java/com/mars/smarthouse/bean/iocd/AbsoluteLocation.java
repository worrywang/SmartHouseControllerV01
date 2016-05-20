
package com.mars.smarthouse.bean.iocd;


public class AbsoluteLocation
{
   private GeoCoordinate geoCoordinate;
   private Address address;

   /**
    @roseuid 5693601E01E9
    */
   public AbsoluteLocation()
   {

   }

   /**
    Access method for the geoCoordinate property.

    @return   the current value of the geoCoordinate property
    */
   public GeoCoordinate getGeoCoordinate()
   {
      return geoCoordinate;
   }

   /**
    Sets the value of the geoCoordinate property.

    @param aGeoCoordinate the new value of the geoCoordinate property
    */
   public void setGeoCoordinate(GeoCoordinate aGeoCoordinate)
   {
      geoCoordinate = aGeoCoordinate;
   }

   /**
    Access method for the address property.

    @return   the current value of the address property
    */
   public Address getAddress()
   {
      return address;
   }

   /**
    Sets the value of the address property.

    @param aAddress the new value of the address property
    */
   public void setAddress(Address aAddress)
   {
      address = aAddress;
   }
}
//Address AbsoluteLocation.getTheAddress(){
//      return theAddress;
//   }
//Address AbsoluteLocation.setTheAddress(lab.mars.smarthome.tv.bean.iocd.Address){
//      theAddress = aTheAddress;
//   }
