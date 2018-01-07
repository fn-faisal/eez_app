package com.eezservices.eez.util.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eezservices.eez.R;

/**
 * Created by Faisal on 05/17/2017.
 */

public class ContactsRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

   public ImageView imageView;
   public TextView textView;


   public ContactsRecyclerViewHolder ( View itemView ) {
      super ( itemView );
      imageView = ( ImageView ) itemView.findViewById ( R.id.contact_image );
      textView = ( TextView ) itemView.findViewById ( R.id.contact_data );
   }

   @Override
   public void onClick ( View view ) {

   }
}
