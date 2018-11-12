package com.example.neto.projetoexemploaulabroadcastnativo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class EnergyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED) ||
           intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED) ) {

            Notification.Builder builder = new Notification.Builder(context);

            builder.setContentTitle("Energia");
            builder.setSmallIcon(android.R.drawable.sym_action_chat);
            builder.setAutoCancel(true);

            switch (intent.getAction()) {
                case Intent.ACTION_POWER_CONNECTED:
                    builder.setContentText("CONECTADO À ENERGIA");
                break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    builder.setContentText("DESCONECTADO DA ENERGIA");
                break;
            }

            Notification notification = builder.build();

            NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify(50, notification);
        }
    }
}
