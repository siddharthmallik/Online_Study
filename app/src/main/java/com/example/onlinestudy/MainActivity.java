package com.example.onlinestudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] gridViewString = {"AboutUs", "JAVA", "Android", "Python", "ContactUs", "Notification"};
    int[] gridViewImageId = {R.drawable.about_us, R.drawable.freetrial, R.drawable.services, R.drawable.prices, R.drawable.contactus, R.drawable.notification};
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.grid_view);
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewString, gridViewImageId);
        gridView.setAdapter(adapterViewAndroid);
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intentAbout = new Intent(MainActivity.this, AboutUs.class);
                        startActivity(intentAbout);
                        break;
                    case 1:
                        Intent free= new Intent(MainActivity.this, FreeTrialActivity.class);
                        startActivity(free);
//                        if (!url.startsWith("https://") && !url.startsWith("http://")) {
//                            url = "http://" + url;
//                        }
//                        Intent intentfreetrail = new Intent(Intent.ACTION_VIEW);
//                        intentfreetrail.setData(Uri.parse(url));
//                        startActivity(intentfreetrail);
                        break;
                    case 2:
                        Intent intentservices = new Intent(MainActivity.this, ServicesActivity.class);
                        startActivity(intentservices);
                        break;
                    case 3:

                        Intent intentprices = new Intent(MainActivity.this, PricesActivity.class);
                        startActivity(intentprices);
                        break;
                    case 4:
                        Intent intentcontact = new Intent(MainActivity.this, ContactActivity.class);
                        startActivity(intentcontact);
                        break;
                    case 5:
                        Intent i=new Intent(getApplicationContext(), ServicesActivity.class);
                        PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,i,0);
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                        long[] vib = {500,1000};
                        mBuilder.setSmallIcon(R.drawable.increase);
                        mBuilder.setContentTitle("Share stock Market");
                        mBuilder.setContentText("Hey ! This is share Stock Market Tips");
                        mBuilder.setColor(Color.RED);
                        mBuilder.setAutoCancel(true);
                        mBuilder.setContentIntent(pi);
                        mBuilder.setVibrate(vib);
                        NotificationManager mNotificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(1, mBuilder.build());
                }
            }
        });













    }
}