package org.fossasia.openevent.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD

import org.fossasia.openevent.data.Session;
import org.fossasia.openevent.receivers.NotificationAlarmReceiver;
import org.threeten.bp.ZonedDateTime;
=======
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.fossasia.openevent.data.Session;
import org.fossasia.openevent.receivers.NotificationAlarmReceiver;

import java.util.Calendar;
>>>>>>> text_align

import io.reactivex.Completable;
import timber.log.Timber;

public class NotificationUtil {

    private static void onSuccess(Session session) {
        Timber.d("Created notification for Session %d %s at time %s",
<<<<<<< HEAD
                session.getId(), session.getTitle(), session.getStartsAt());
=======
                session.getId(), session.getTitle(), session.getStartTime());
>>>>>>> text_align
    }

    private static void onError(Throwable throwable, Session session) {
        Timber.e(throwable);
        Timber.e("Error creating Date for Session %ld %s at time %s",
<<<<<<< HEAD
                session.getId(), session.getTitle(), session.getStartsAt());
=======
                session.getId(), session.getTitle(), session.getStartTime());
>>>>>>> text_align
    }

    public static Completable createNotification(Session session, Context context) {
        return Completable.fromAction(() -> {
<<<<<<< HEAD
            ZonedDateTime zonedDateTime = DateConverter.getDate(session.getStartsAt());

            Integer pref_result = Integer.parseInt(SharedPreferencesUtil.getString("notification", "10 mins").substring(0, 2).trim());
            if (pref_result.equals(1)) {
                zonedDateTime.minusHours(-1);
            } else if (pref_result.equals(12)) {
                zonedDateTime.minusHours(12);
            } else {
                zonedDateTime.minusMinutes(10);
            }
            // Checking if the event time is after the current time
            if (zonedDateTime.isAfter(ZonedDateTime.now())) {
                Intent myIntent = new Intent(context, NotificationAlarmReceiver.class);
                myIntent.putExtra(ConstantStrings.SESSION, session.getId());
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC, zonedDateTime.toInstant().toEpochMilli(), pendingIntent);
            } else {
                Timber.d("Session is finished. Skipping showing notification");
            }
=======
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateUtils.getDate(session.getStartTime()));

            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            Integer pref_result = Integer.parseInt(sharedPrefs.getString("notification", "10 mins").substring(0, 2).trim());
            if (pref_result.equals(1)) {
                calendar.add(Calendar.HOUR, -1);
            } else if (pref_result.equals(12)) {
                calendar.add(Calendar.HOUR, -12);
            } else {
                calendar.add(Calendar.MINUTE, -10);
            }
            Intent myIntent = new Intent(context, NotificationAlarmReceiver.class);
            myIntent.putExtra(ConstantStrings.SESSION, session.getId());
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
>>>>>>> text_align
        }).doOnComplete(() -> onSuccess(session)).doOnError(throwable -> onError(throwable, session));
    }
}
