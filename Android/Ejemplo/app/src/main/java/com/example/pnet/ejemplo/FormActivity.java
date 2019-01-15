package com.example.pnet.ejemplo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FormActivity extends AppCompatActivity {

    private EditText name;
    private EditText dni;
    private EditText email;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = (EditText) findViewById(R.id.name);
        dni = (EditText) findViewById(R.id.dni);
        email = (EditText) findViewById(R.id.email);

        send = (Button) findViewById(R.id.add);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetIOPOST().execute();
            }
        });
    }

    public class LongRunningGetIOPOST extends AsyncTask<Void, Void, Boolean> {
        public final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");
        @Override
        protected Boolean doInBackground(Void... params) {

            String text = null;
            OkHttpClient client = new OkHttpClient();
            JSONObject json = new JSONObject();

            try{
                json.put("firstname", name.getText().toString());
                json.put("DNI", dni.getText().toString());
                json.put("email", email.getText().toString());
            }catch (JSONException e) {
                e.printStackTrace();
            }

            RequestBody body = RequestBody.create(JSON, json.toString());
            Request request = new Request.Builder().url("http://192.168.1.23:8080/users")
                    .post(body)
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
        //return text

        @Override
        protected void onPostExecute(Boolean results) {
            if(!results)
                Toast.makeText(getApplicationContext(), "Fallo al insertar",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Usuario insertado correctamente",Toast.LENGTH_LONG).show();
        }

    }
}
