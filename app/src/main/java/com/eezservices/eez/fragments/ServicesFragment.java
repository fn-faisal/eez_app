package com.eezservices.eez.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eezservices.eez.R;
import com.eezservices.eez.util.service.ServicesRecyclerViewAdapter;
import com.eezservices.eez.util.service.Service;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {

   private LinearLayoutManager linearLayoutManager;
   private RecyclerView recyclerView;

   public ServicesFragment () {
      // Required empty public constructor
   }

   @Override
   public void onCreate ( Bundle savedInstanceState ) {
      super.onCreate ( savedInstanceState );
   }

   @Override
   public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
      // Inflate the layout for this fragment
      View parent = inflater.inflate ( R.layout.fragment_services, container, false );

      initServiceGrid ( getContext () , parent );

      return parent;
   }

   private ArrayList< Service > getServiceList () {
      ArrayList < Service > serviceList = new ArrayList <> ();

      // Direct Mail Marketing
      serviceList.add ( new Service ( "Direct Mail Marketing", R.drawable.direct_mail_marketing ) );

      // Accidental Insurance
      serviceList.add ( new Service ( "Accidental Insurance", R.drawable.accidental_insurance ) );

      // Email Marketing
      serviceList.add ( new Service ( "Email Marketing", R.drawable.email_marketing_3 ) );

      // whatsapp Marketing
      serviceList.add ( new Service ( "WhatsApp Marketing", R.drawable.whatsapp_marketing_1 ) );

      return serviceList;
   }

   private void initServiceGrid ( Context context , View parent ) {
      ArrayList < Service > serviceArrayList = getServiceList ();

      linearLayoutManager = new LinearLayoutManager ( context );

      recyclerView = ( RecyclerView ) parent.findViewById ( R.id.service_recycler_view );
      recyclerView.setLayoutManager ( linearLayoutManager );

      ServicesRecyclerViewAdapter rcv = new ServicesRecyclerViewAdapter ( context, serviceArrayList );
      recyclerView.setAdapter ( rcv );
   }


}
