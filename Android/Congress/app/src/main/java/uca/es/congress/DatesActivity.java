package uca.es.congress;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DatesActivity extends AppCompatActivity {
    CalendarView calendarView;
    ImageButton imageButton;
    TextView text;
    Calendar calendar = Calendar.getInstance();
    private static final int NOTIF_ALERTA_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates);



        calendarView = (CalendarView) findViewById(R.id.calendar);

        text = (TextView) findViewById(R.id.datetext);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Date date = getDate(i, i1, i2);
                Date today = Calendar.getInstance().getTime();
                calendar.setTime(date);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");

                int day = calendar.get(Calendar.DAY_OF_MONTH);
                String s = (simpleDateFormat.format(date));
                s += " "+ day + " ";
                simpleDateFormat = new SimpleDateFormat("MMMM");
                s += (simpleDateFormat.format(date) + " ");
                simpleDateFormat = new SimpleDateFormat("YYYY");
                s += (simpleDateFormat.format(date));

                int dayofWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                int month = calendar.get(Calendar.MONTH) + 1;

                text.setText(s);
                imageButton = (ImageButton) findViewById(R.id.imageButton);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NotificationCompat.Builder notificacion =
                                new NotificationCompat.Builder(DatesActivity.this, "default")
                                .setSmallIcon(R.drawable.android)
                                .setLargeIcon(BitmapFactory.decodeResource
                                        (getResources(), R.drawable.android))
                                .setContentTitle("Localizacion")
                                .setContentText("Moverse a localizacion.")
                                .setContentInfo("4")
                                .setTicker("Alerta!");

                        Intent notIntent = new Intent(DatesActivity.this, LocationActivity.class); //EL SEGUNDO PARAMETRO DEBE SER LA ACTIVIDAD DE LOCALIZACIÓN
                        PendingIntent contIntent =
                                PendingIntent.getActivity(DatesActivity.this, 0, notIntent, 0);

                        notificacion.setContentIntent(contIntent);

                        NotificationManager mNotificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        // Since android Oreo notification channel is needed.
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel("default",
                                    "Default channel",
                                    NotificationManager.IMPORTANCE_DEFAULT);
                            mNotificationManager.createNotificationChannel(channel);
                        }

                        mNotificationManager.notify(NOTIF_ALERTA_ID, notificacion.build());
                    }
                });
                int res = today.compareTo(date);
                if(res > 0)
                    Toast.makeText(getApplicationContext(), "Ya ha pasado la fecha seleccionada",Toast.LENGTH_LONG).show();
                else{
                    long dif = date.getTime() - today.getTime();
                    int diffDays = (int) (dif / (24 * 60 * 60 * 1000));
                    Snackbar.make(findViewById(R.id.datesview), "Dias restantes para el evento: "+ diffDays, Snackbar.LENGTH_LONG).show();
                }
                //Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
            }
        });



    }

    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.see_users)
        {
            Intent intent = new Intent(this, UsersActivity.class);
            startActivity(intent);
        }

        if(id == R.id.program)
        {
            Intent intent = new Intent(this, ProgramActivity.class);
            startActivity(intent);
        }

        if(id == R.id.dates)
        {
            Intent intent = new Intent(this, DatesActivity.class);
            startActivity(intent);
        }

        if(id == R.id.map)
        {
            Intent intent = new Intent(this, LocationActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
