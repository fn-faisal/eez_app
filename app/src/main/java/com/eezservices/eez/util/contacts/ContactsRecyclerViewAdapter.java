package com.eezservices.eez.util.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eezservices.eez.R;
import com.eezservices.eez.util.service.Service;

import java.util.ArrayList;

/**
 * Created by Faisal on 05/17/2017.
 */

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewHolder > {

   private ArrayList<Contact> contactArrayList;
   private Context context;

   public ContactsRecyclerViewAdapter ( ArrayList < Contact > contactArrayList, Context context ) {
      this.contactArrayList = contactArrayList;
      this.context = context;
   }

   @Override
   public ContactsRecyclerViewHolder onCreateViewHolder ( ViewGroup parent, int viewType ) {
      View layoutView = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.contacts_rcv_item , null );
      ContactsRecyclerViewHolder cth = new ContactsRecyclerViewHolder ( layoutView );
      return cth;
   }

   @Override
   public void onBindViewHolder ( ContactsRecyclerViewHolder holder, int position ) {
      holder.imageView.setImageResource ( contactArrayList.get ( position ).getContactId () );
      holder.textView.setText ( contactArrayList.get ( position ).getContactData () );
   }

   @Override
   public int getItemCount () {
      return contactArrayList.size ();
   }
}
