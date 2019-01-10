package uca.es.congress;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FormActivity extends AppCompatActivity {

    private TextView displaydate;
    private TextView displaydateend;

    private EditText name;
    private EditText lastname;
    private EditText email;
    private EditText dni;
    private EditText telephone;
    private Spinner type;

    private Button sendBtn;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        displaydate = (TextView) findViewById(R.id.editstartdate);
        displaydateend = (TextView) findViewById(R.id.editenddate);

        sendBtn = (Button) findViewById(R.id.btnSend);

        displaydate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FormActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        displaydateend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FormActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                displaydate.setText(date);
            }
        };

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                displaydateend.setText(date);
            }
        };

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetIOPOST().execute();
                //tarea1 = new MiTareaAsincrona();
                //tarea1.execute();
            }
        });



    }

    public class LongRunningGetIOPOST extends AsyncTask<Void, Void, Boolean> {
        public final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");
        @Override
        protected Boolean doInBackground(Void... params) {

            String text = null;
            //HttpURLConnection urlConnection = null;
            OkHttpClient client = new OkHttpClient();
            JSONObject json = new JSONObject();
            name = (EditText) findViewById(R.id.editname);
            lastname = (EditText) findViewById(R.id.editlastname);
            email = (EditText) findViewById((R.id.editemail));
            dni = (EditText) findViewById(R.id.editdni);
            telephone = (EditText) findViewById(R.id.edittelephone);
            type = (Spinner) findViewById(R.id.SpinnerFeedbackType);

            int telephoneint = Integer.parseInt(telephone.getText().toString());

            try{
                json.put("firstname", name.getText().toString());
                json.put("lastname", lastname.getText().toString());
                json.put("DNI", dni.getText().toString());
                json.put("telephone", telephoneint);
                json.put("email", email.getText().toString());
                json.put("Inscription type", type.getSelectedItem().toString());
                json.put("start date", displaydate.getText().toString());
                json.put("finish date", displaydateend.getText().toString());
            }catch (JSONException e) {
                e.printStackTrace();
            }

            RequestBody body = RequestBody.create(JSON, json.toString());
            Request request = new Request.Builder().url("http://192.168.1.15:8080/users")
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
