package com.eezservices.eez.util.service;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eezservices.eez.R;

/**
 * Created by Faisal on 05/14/2017.
 */

public class ServicesRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

   public ImageView imageView;
   public TextView textView;

   public ServicesRecyclerViewHolder ( View itemView ) {
      super ( itemView );
      itemView.setOnClickListener ( this );
      imageView = ( ImageView ) itemView.findViewById ( R.id.service_photo );
      textView = ( TextView ) itemView.findViewById ( R.id.service_name );
   }

   @Override
   public void onClick ( View view ) {
      Toast.makeText ( view.getContext () , "Clicked : "+textView.getText ().toString () , Toast.LENGTH_LONG ).show ();
   }
}
