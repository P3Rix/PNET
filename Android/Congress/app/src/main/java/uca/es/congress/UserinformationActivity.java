package uca.es.congress;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserinformationActivity extends AppCompatActivity {

    private TextView resName;
    private TextView resLastname;
    private TextView resDNI;
    private TextView resemail;
    private TextView resTelephone;
    private TextView resInitDate;
    private TextView resEndDate;

    private Button editUser;
    private Button deleteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);

        resName = (TextView) findViewById(R.id.resName);
        resLastname = (TextView) findViewById(R.id.resLastname);
        resDNI = (TextView) findViewById(R.id.resDni);
        resemail = (TextView) findViewById(R.id.resEmail);
        resTelephone = (TextView) findViewById(R.id.resTelephone);
        resInitDate = (TextView) findViewById(R.id.resinitDate);
        resEndDate = (TextView) findViewById(R.id.resendDate);

        editUser = (Button) findViewById(R.id.editButton);
        deleteUser = (Button) findViewById(R.id.deleteButton);

        Intent i = getIntent();
        Users user = (Users)i.getSerializableExtra("sampleObject");
        final Users edit = user;

        resName.setText(user.getName());
        resLastname.setText(user.getLastname());
        resDNI.setText(user.getDni());
        resemail.setText(user.getEmail());
        String telephone = Integer.toString(user.getTelephone());
        resTelephone.setText(telephone);
        resInitDate.setText(user.getStart_date());
        resEndDate.setText(user.getEnd_date());

        editUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), FormActivity.class);
                Toast.makeText(getApplicationContext(), edit.getName(),Toast.LENGTH_LONG).show();
                i.putExtra("editUser", edit);
                v.getContext().startActivity(i);
            }
        });

        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetIODELETE().execute();
                Intent i = new Intent(v.getContext(), UsersActivity.class);
                startActivity(i);
            }
        });

    }

    public class LongRunningGetIODELETE extends AsyncTask<Void, Void, Boolean> {
        public final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");
        @Override
        protected Boolean doInBackground(Void... params) {

            String text = null;
            //HttpURLConnection urlConnection = null;
            OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder().url("http://192.168.1.24:8080/users/"+ resDNI.getText().toString())
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
        //return text

        @Override
        protected void onPostExecute(Boolean results) {
            if(!results)
                Toast.makeText(getApplicationContext(), "Fallo al borrar",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Usuario borrado correctamente",Toast.LENGTH_LONG).show();

        }

    }
}
