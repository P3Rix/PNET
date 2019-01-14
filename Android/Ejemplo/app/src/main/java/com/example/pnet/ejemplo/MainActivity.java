package com.example.pnet.ejemplo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView DNI;
    private Button getAll;
    private Button getOne;
    private Button deleteOne;
    private Button post;
    private static ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Referenciamos al RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //Referenciamos los botones para las peticiones
        getAll = (Button) findViewById(R.id.Getall);
        getOne = (Button) findViewById(R.id.Getone);
        deleteOne = (Button) findViewById(R.id.Deleteone);
        post = (Button) findViewById(R.id.Post);

        DNI = (TextView) findViewById(R.id.dni);

        // Mejoramos rendimiento con esta configuración
        mRecyclerView.setHasFixedSize(true);

        users = new ArrayList<User>();

        // Creamos un LinearLayoutManager para gestionar el item.xml creado antes
        mLayoutManager = new LinearLayoutManager(this);
        // Lo asociamos al RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);

        getAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetIO().execute();
            }
        });

        getOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetOneIO().execute();
            }
        });

        deleteOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetIODELETE().execute();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public class LongRunningGetIO extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String text = null;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://192.168.1.18:8080/users")
                    .build();
            try {
                Response res = client.newCall(request).execute();
                return res.body().string();
            } catch (Exception e) {
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String results) {
            //JSONObject respJson = null;
            JSONArray json = null;
            if (results == null) {
            }
            if (results != null) {
                try {
                    json = new JSONArray(results);
                    for (int i = 0; i < json.length(); i++) {
                        users.add(new User(json.getJSONObject(i).get("firstname").toString(),
                                json.getJSONObject(i).get("DNI").toString(),
                                json.getJSONObject(i).get("email").toString()
                                ));
                    }

                    mAdapter = new UserAdapter(users);

                    mRecyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public class LongRunningGetOneIO extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String text = null;
            OkHttpClient client = new OkHttpClient();
            String dni = DNI.getText().toString();
            Request request = new Request.Builder().url("http://192.168.1.18:8080/users/" + dni)
                    .build();
            try {
                Response res = client.newCall(request).execute();
                return res.body().string();
            } catch (Exception e) {
                return e.toString();
            }
        }

        @Override
        protected void onPostExecute(String results) {
            //JSONObject respJson = null;
            JSONArray json = null;
            if (results == null) {
            }
            if (results != null) {
                try {
                    json = new JSONArray(results);
                        users.add(new User(json.getJSONObject(0).get("firstname").toString(),
                                json.getJSONObject(0).get("DNI").toString(),
                                json.getJSONObject(0).get("email").toString()
                        ));


                    mAdapter = new UserAdapter(users);

                    mRecyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public class LongRunningGetIODELETE extends AsyncTask<Void, Void, Boolean> {
        public final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");
        @Override
        protected Boolean doInBackground(Void... params) {

            String text = null;
            OkHttpClient client = new OkHttpClient();
            String dni = DNI.getText().toString();
            Request request = new Request.Builder().url("http://192.168.1.18:8080/users/"+ dni)
                    .delete()
                    .build();
            try {
                Response res = client.newCall(request).execute();
                if(!res.isSuccessful())
                    return false;
                else
                    return true;
            } catch (Exception e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean results) {
            if(!results)
                Toast.makeText(getApplicationContext(), "Fallo al borrar",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Usuario borrado correctamente",Toast.LENGTH_LONG).show();

        }

    }
}
