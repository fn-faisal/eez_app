package com.eezservices.eez;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.eezservices.eez.fragments.ContactsFragment;
import com.eezservices.eez.fragments.ServicesFragment;
import com.eezservices.eez.util.service.Service;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   // tab layout
   private TabLayout tabLayout;
   private ViewPager viewPager;

   // recycler view widget
   private RecyclerView recyclerView;
   private LinearLayoutManager linearLayoutManager;

   private CountDownTimer demoCountDownTimer;

   @Override
   protected void onCreate ( Bundle savedInstanceState ) {
      super.onCreate ( savedInstanceState );
      setContentView ( R.layout.activity_main );

      initToolbar ();
      setupTabLayout ();
      initSocialLinks ();

      runDemoBanner ();
   }

   @Override
   public boolean onCreateOptionsMenu ( Menu menu ) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater ().inflate ( R.menu.menu_main, menu );
      return true;
   }

   @Override
   public boolean onOptionsItemSelected ( MenuItem item ) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId ();

      //noinspection SimplifiableIfStatement
      if ( id == R.id.action_settings ) {
         return true;
      }

      return super.onOptionsItemSelected ( item );
   }

   /*
   *  Helper Methods
   * */

   /**
    * setup the tabbed layout
    */
   public void setupTabLayout () {

      viewPager = ( ViewPager ) findViewById ( R.id.tab_viewpager );
      if ( viewPager != null ) {
         setupViewPager ( viewPager );
      }

      TabLayout tabLayout = ( TabLayout ) findViewById ( R.id.tab_layout );
      tabLayout.setupWithViewPager ( viewPager );

      tabLayout.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
         @Override
         public void onTabSelected ( TabLayout.Tab tab ) {
            viewPager.setCurrentItem ( tab.getPosition () );
         }

         @Override
         public void onTabUnselected ( TabLayout.Tab tab ) {
         }

         @Override
         public void onTabReselected ( TabLayout.Tab tab ) {
         }
      } );

   }

   public void setupViewPager ( ViewPager viewPager ) {
      ViewPagerAdapter adapter = new ViewPagerAdapter ( getSupportFragmentManager () );

      // add the services fragment here.
      adapter.addFragment ( new ServicesFragment (), " Services " );

      // add the contacts fragment here.
      adapter.addFragment ( new ContactsFragment (), " Contacts " );

      viewPager.setAdapter ( adapter );
   }

   /**
    * Helper method
    */

   public void initSocialLinks () {
      // social links
      ImageView dailymotion = ( ImageView ) findViewById ( R.id.social_dailymotion );
      ImageView facebook = ( ImageView ) findViewById ( R.id.social_facebook );
      ImageView googlePlus = ( ImageView ) findViewById ( R.id.social_google_plus );
      //ImageView instagram = ( ImageView ) findViewById ( R.id.social_instagram );
      ImageView pinterest = ( ImageView ) findViewById ( R.id.social_pinterest );
      ImageView twitter = ( ImageView ) findViewById ( R.id.social_twitter );
      ImageView youtube = ( ImageView ) findViewById ( R.id.social_youtube );

      // the dailymotion account http://www.dailymotion.com/eez-multiple-services
      dailymotion.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick ( View view ) {
            String url = "http://www.dailymotion.com/eez-multiple-services";
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( url ) );
            startActivity ( intent );
         }
      } );

      // the googleplus account
      googlePlus.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick ( View view ) {
            String url = "https://plus.google.com/u/0/";
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( url ) );
            startActivity ( intent );
         }
      } );

      // the youtube account https://www.youtube.com/channel/UC3YZUy5FTCzSgEEPiiH2dRg
      youtube.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick ( View view ) {
            String url = "https://www.youtube.com/channel/UC3YZUy5FTCzSgEEPiiH2dRg";
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( url ) );
            startActivity ( intent );
         }
      } );

      // the pinterest account https://www.pinterest.com/eezmultipleserv/pins/
      pinterest.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick ( View view ) {
            String url = "https://www.pinterest.com/eezmultipleserv/pins/";
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( url ) );
            startActivity ( intent );
         }
      } );

      // the facebook account https://www.facebook.com/EEZMultipleServices
      facebook.setOnClickListener ( new View.OnClickListener () {
         @Override
         public void onClick ( View view ) {
            String url = "https://www.facebook.com/EEZMultipleServices";
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( url ) );
            startActivity ( intent );
         }
      } );


   }

   public void runDemoBanner () {
      final ArrayList<Integer> adList = new ArrayList <Integer> (  );

      adList.add ( R.drawable.adv_1 );
      adList.add ( R.drawable.adv_2 );
      adList.add ( R.drawable.adv_3 );
      adList.add ( R.drawable.adv_4 );
      adList.add ( R.drawable.adv_5 );
      adList.add ( R.drawable.adv_6 );
      adList.add ( R.drawable.adv_7 );

      final ImageView adBanner = ( ImageView ) findViewById ( R.id.ad_banner_top );

      if ( demoCountDownTimer != null ) {
         demoCountDownTimer.cancel ();
      }

      demoCountDownTimer = new CountDownTimer ( 5000, 3000 ) {

         private int position = 0;

         public void onTick ( long millisUntilFinished ) {

            if ( position == adList.size () )
               position = 0;

            adBanner.setImageResource ( adList.get ( position ) );
            position++;

         }

         public void onFinish () {
            demoCountDownTimer.start ();
         }
      };

      demoCountDownTimer.start ();
   }

   public void initToolbar () {
      Toolbar toolbar = ( Toolbar ) findViewById ( R.id.toolbar );
      setSupportActionBar ( toolbar );
      toolbar.setTitleTextColor ( ContextCompat.getColor (this, R.color.colorPrimaryLight ) );
   }


   /**
    * Helper classes
    */
   public class ViewPagerAdapter extends FragmentPagerAdapter {

      private ArrayList < Fragment > fragmentList = new ArrayList < Fragment > ();
      private ArrayList < String > fragmentTitleList = new ArrayList < String > ();

      public ViewPagerAdapter ( FragmentManager fm ) {
         super ( fm );
      }

      /**
       * Add a fragment to the tab list.
       *
       * @param fragment      the fragment to add.
       * @param fragmentTitle the title for this fragment in the tab.
       */
      public void addFragment ( Fragment fragment, String fragmentTitle ) {
         this.fragmentList.add ( fragment );
         this.fragmentTitleList.add ( fragmentTitle );
      }

      @Override
      public Fragment getItem ( int position ) {
         return fragmentList.get ( position );
      }

      @Override
      public int getCount () {
         return fragmentList.size ();
      }

      @Override
      public CharSequence getPageTitle ( int position ) {
         return fragmentTitleList.get ( position );
      }
   }

}
