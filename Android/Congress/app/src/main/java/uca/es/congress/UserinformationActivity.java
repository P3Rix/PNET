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

    String id;

    private Button editUser;
    private Button deleteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);

        resName = (TextView) findViewById(R.id.name);
        resLastname = (TextView) findViewById(R.id.lastname);
        resDNI = (TextView) findViewById(R.id.dni);
        resemail = (TextView) findViewById(R.id.email);
        resTelephone = (TextView) findViewById(R.id.telephone);
        resInitDate = (TextView) findViewById(R.id.initDate);
        resEndDate = (TextView) findViewById(R.id.endDate);

        editUser = (Button) findViewById(R.id.editButton);
        deleteUser = (Button) findViewById(R.id.deleteButton);

        Intent i = getIntent();
        Users user = (Users)i.getSerializableExtra("sampleObject");
        final Users edit = user;

        id = user.getDni();

        resName.setText(resName.getText()+" "+ user.getName());
        resLastname.setText(resLastname.getText() +" "+user.getLastname());
        resDNI.setText(resDNI.getText() + " "+ user.getDni());
        resemail.setText(resemail.getText() + " "+ user.getEmail());
        String telephone = Integer.toString(user.getTelephone());
        resTelephone.setText(resTelephone.getText() + " " + telephone);
        resInitDate.setText(resInitDate.getText() + " "+ user.getStart_date());
        resEndDate.setText(resEndDate.getText() + " "+user.getEnd_date());

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
            OkHttpClient client = new OkHttpClient();


            Request request = new Request.Builder().url("http://192.168.1.10:8080/users/"+ id)
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
