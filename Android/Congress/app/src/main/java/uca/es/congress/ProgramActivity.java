package uca.es.congress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.database.MatrixCursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {

    private ListView items;
    private ProgramAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        Button fridayButton, saturdayButton, sundayButton;
        final ArrayList<Programa> listFriday = new ArrayList<>();
        final ArrayList<Programa> listSaturday = new ArrayList<>();
        final ArrayList<Programa> listSunday = new ArrayList<>();

        fillArrays(listFriday, listSaturday, listSunday);

        fridayButton = findViewById(R.id.ButtonFriday);
        saturdayButton = findViewById(R.id.ButtonSaturday);
        sundayButton = findViewById(R.id.ButtonSunday);

        fridayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ProgramAdapter(v.getContext(), listFriday);
                items.setAdapter(adapter);
            }
        });

        saturdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ProgramAdapter(v.getContext(), listSaturday);
                items.setAdapter(adapter);
            }
        });


        sundayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ProgramAdapter(v.getContext(), listSunday);
                items.setAdapter(adapter);
            }
        });

        items = (ListView)findViewById(R.id.items);
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

    void fillArrays(ArrayList<Programa> listFriday, ArrayList<Programa> listSaturday,
                    ArrayList<Programa> listSunday){

        //VIERNES
        listFriday.add(new Programa(R.mipmap.android, "15:00-16:00"));
        listFriday.add(new Programa(R.mipmap.apple, "16:00-17:00"));

        //SABADO
        listSaturday.add(new Programa(R.mipmap.asus, "15:00-16:00"));
        listSaturday.add(new Programa(R.mipmap.blackberry, "16:00-17:00"));

        //DOMINGO
        listSunday.add(new Programa(R.mipmap.htc, "15:00-16:00"));
        listSunday.add(new Programa(R.mipmap.bq, "16:00-17:00"));

    }

}
