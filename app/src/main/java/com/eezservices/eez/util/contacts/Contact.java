package com.eezservices.eez.util.contacts;

/**
 * Created by Faisal on 05/17/2017.
 */

public class Contact {

   private int contactId;
   private String contactData;

   public Contact ( int contactId, String contactData ) {
      this.contactId = contactId;
      this.contactData = contactData;
   }

   public int getContactId () {
      return contactId;
   }

   public void setContactId ( int contactId ) {
      this.contactId = contactId;
   }

   public String getContactData () {
      return contactData;
   }

   public void setContactData ( String contactData ) {
      this.contactData = contactData;
   }
}
