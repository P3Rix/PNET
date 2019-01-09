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
        ArrayList<Programa> list = new ArrayList<>();
        list.add(new Programa(R.mipmap.android, "15:00-16:00"));
        list.add(new Programa(R.mipmap.apple, "16:00-17:00"));
        items = (ListView)findViewById(R.id.items);
        adapter = new ProgramAdapter(this, list);
        items.setAdapter(adapter);
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

        return super.onOptionsItemSelected(item);
    }



}
