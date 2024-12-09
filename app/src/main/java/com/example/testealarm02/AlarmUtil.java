package com.example.testealarm02;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class AlarmUtil {
    public static void adicionarAlarm(Context c, int hora, int minuto) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minuto);

        AlarmManager alarmManager = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = criarPandinIntent(c);

        //não garante e exatidão, para o alarme
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

    }//adicionar Alarme

    private static PendingIntent criarPandinIntent(Context c) {
        Intent intent = new Intent(c, AlarmReceiver.class);
        return PendingIntent.getBroadcast(c, 0, intent, PendingIntent.FLAG_IMMUTABLE);
    }// criar PandinIntent

    public static void cancelarAlarm(Context c){
        AlarmManager alarmManager = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = criarPandinIntent(c);
        alarmManager.cancel(pendingIntent);
    }


}//Class
