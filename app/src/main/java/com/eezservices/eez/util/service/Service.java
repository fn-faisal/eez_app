package com.eezservices.eez.util.service;

/**
 * Created by Faisal on 05/15/2017.
 */

public class Service {

   private String serviceName;
   private int serviceImageId;

   public Service ( String serviceName, int serviceImageId ) {
      this.serviceName = serviceName;
      this.serviceImageId = serviceImageId;
   }

   public String getServiceName () {
      return serviceName;
   }

   public void setServiceName ( String serviceName ) {
      this.serviceName = serviceName;
   }

   public int getServiceImageId () {
      return serviceImageId;
   }

   public void setServiceImageId ( int serviceImageId ) {
      this.serviceImageId = serviceImageId;
   }
}
