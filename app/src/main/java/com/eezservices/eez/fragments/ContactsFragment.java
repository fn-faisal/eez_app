package com.eezservices.eez.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eezservices.eez.R;
import com.eezservices.eez.util.contacts.Contact;
import com.eezservices.eez.util.contacts.ContactsRecyclerViewAdapter;
import com.eezservices.eez.util.service.Service;
import com.eezservices.eez.util.service.ServicesRecyclerViewAdapter;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {

   private LinearLayoutManager linearLayoutManager;
   private RecyclerView recyclerView;

   public ContactsFragment () {
      // Required empty public constructor
   }

   @Override
   public void onCreate ( Bundle savedInstanceState ) {
      super.onCreate ( savedInstanceState );
   }

   @Override
   public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
      View parent = inflater.inflate ( R.layout.fragment_contacts, container, false );
      initContactGrid ( getContext () , parent );
      return parent;
   }

   private ArrayList < Contact > getContactList () {
      ArrayList < Contact > contactList = new ArrayList <> ();

      // Address
      contactList.add ( new Contact ( R.drawable.location, "F1, First Floor Safdar Mansion, Blue Area, Islamabad" ) );

      // Phone
      contactList.add ( new Contact ( R.drawable.phone , "+925128052423" ) );

      // Mobile
      contactList.add ( new Contact ( R.drawable.mobile , "+923041111339" ) );

      // Email
      contactList.add ( new Contact ( R.drawable.email , "services@eez.com" ) );

      // Web
      contactList.add ( new Contact ( R.drawable.web , "eezservices.com" ) );

      return contactList;

   }

   private void initContactGrid ( Context context , View parent ) {
      ArrayList < Contact > contactArrayList = getContactList ();

      linearLayoutManager = new LinearLayoutManager ( context );

      recyclerView = ( RecyclerView ) parent.findViewById ( R.id.contacts_recycler_view );
      recyclerView.setLayoutManager ( linearLayoutManager );

      ContactsRecyclerViewAdapter rcv = new ContactsRecyclerViewAdapter ( contactArrayList, context  );
      recyclerView.setAdapter ( rcv );
   }

}