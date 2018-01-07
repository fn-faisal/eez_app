package com.eezservices.eez.util.service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eezservices.eez.R;

import java.util.ArrayList;

/**
 * Created by Faisal on 05/14/2017.
 */

public class ServicesRecyclerViewAdapter extends RecyclerView.Adapter<ServicesRecyclerViewHolder > {

   private ArrayList<Service> serviceArrayList;
   private Context context;

   public ServicesRecyclerViewAdapter ( Context context, ArrayList<Service> serviceArrayList){
      this.serviceArrayList = serviceArrayList;
      this.context = context;

   }

   @Override
   public ServicesRecyclerViewHolder onCreateViewHolder ( ViewGroup parent, int viewType ) {

      View layoutView = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.service_rcv_item, null );
      ServicesRecyclerViewHolder recyclerViewHolder = new ServicesRecyclerViewHolder ( layoutView );

      return recyclerViewHolder;
   }

   @Override
   public void onBindViewHolder ( ServicesRecyclerViewHolder holder, int position ) {

      // set the service name
      holder.textView.setText ( serviceArrayList.get ( position ).getServiceName () );

      // set the service image
      holder.imageView.setImageResource ( serviceArrayList.get ( position ).getServiceImageId () );

   }

   @Override
   public int getItemCount () {
      return serviceArrayList.size ();
   }
}
