package com.example.randona.jolines;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder mBuilder;
    //Puede ser cualquier numero. Es para agrupar notificaciones
    int mNotificationId = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Incluimos la libreria v4.app.NC
    //El icono lo sacamos de las librerias de android
        mBuilder = new NotificationCompat.Builder (this)
                        .setSmallIcon(android.R.drawable.ic_notification_clear_all)
                        .setContentTitle("Angular notification")
                        .setContentText("Tienes un nuevo Angulo");
        //Cuando el usuario haga click en la notificacion me mandara a un activity
        //Debemos crear el ResultActivity.class ademas de importar las librerias
        Intent resultIntent = new Intent(this, ResultActivity.class);
        //Actualiza la pila de ejecucion de los activities para saber de que activitie veniamos cuando volvemos para atras
        //Como venimos de una notificacion nos devuelve a la pantalla de inicio
        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        //Con esto asociamos nuestro Pending Intent con el builder
        mBuilder.setContentIntent(resultPendingIntent);
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        //El primero es el digito unico y el 2do es el constructor de 2 lineas arriba que llama todo el texto
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
