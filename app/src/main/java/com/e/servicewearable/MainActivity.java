package com.e.servicewearable;

import android.app.Notification;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createChannel.CreateChannel;

public class MainActivity extends AppCompatActivity {

    private Button btnDisplayNotification1;
    private Button getBtnDisplayNotification2;

    NotificationManagerCompat notificationManagerCompat;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplayNotification1 = findViewById(R.id.btnDisplayNotifiaction1);
        getBtnDisplayNotification2 = findViewById(R.id.btnDisplayNotifiaction2);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btnDisplayNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification1();
            }
        });
        getBtnDisplayNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });

    }
    int id = 1;
    private void DisplayNotification1(){
       Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_chat_bubble_black_24dp)
                .setContentTitle("No Commection")
                .setContentText("No Connectivity, please connect")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
               .build();


        notificationManagerCompat.notify(id, notification);
        id++;

    }

    private void DisplayNotification2(){

        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_chat_bubble_black_24dp)
                .setContentTitle("Connected")
                .setContentText("You have been connected to a network")

                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(id, notification);
        id++;
    }

}

