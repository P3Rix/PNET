package uca.es.congress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    }
}
