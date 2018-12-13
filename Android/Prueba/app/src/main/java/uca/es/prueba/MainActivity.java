package uca.es.prueba;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    /*
    private Button buttonAceptar;
    private TextView TxtName;
    private EditText editText; */

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnStart;
    private static ArrayList<Mobiles> mobiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciamos al RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        btnStart = (Button) findViewById(R.id.btnStart);

        // Mejoramos rendimiento con esta configuración
        mRecyclerView.setHasFixedSize(true);

        mobiles = new ArrayList<Mobiles>();

        // Creamos un LinearLayoutManager para gestionar el item.xml creado antes
        mLayoutManager = new LinearLayoutManager(this);
        // Lo asociamos al RecyclerView
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Creamos un ArrayList de Pokemons
        /*
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        // Creamos un PokemonAdapter pasándole todos nuestro Pokemons
        mAdapter = new uca.es.test.PokemonAdapter(pokemons);
    // Asociamos el adaptador al RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        pokemons.add(new Pokemon(1, "Bulbasaur"));
        pokemons.add(new Pokemon(2, "Ivysaur"));
        pokemons.add(new Pokemon(3, "Venusaur"));

        pokemons.add(new Pokemon(4, "Charmander"));
        pokemons.add(new Pokemon(5, "Charmeleon"));
        pokemons.add(new Pokemon(6, "Charizard"));

        pokemons.add(new Pokemon(7, "Squirtle"));
        pokemons.add(new Pokemon(8, "Wartortle"));
        pokemons.add(new Pokemon(9, "Blastoise")); */





        mobiles.add(new Mobiles("hola", "hola", 2));

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LongRunningGetIO().execute();
                //tarea1 = new MiTareaAsincrona();
                //tarea1.execute();
            }
        });




        /*
        buttonAceptar = (Button) findViewById(R.id.mybutton);
        TxtName = (TextView) findViewById(R.id.mytext);
        editText = (EditText) findViewById(R.id.myedittext);
        */

        /*
        buttonAceptar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //String name = "CAMBIADO";
                        TxtName.setText(editText.getText().toString());
                    }
                }); */
    }

    public class LongRunningGetIO extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String text = null;
            //HttpURLConnection urlConnection = null;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://10.182.105.89:8080/mobiles")
                    .build();
            try {
                /*
                URL urlToRequest =
                        new URL("https://jsonplaceholder.typicode.com/todos/1");
                urlConnection = (HttpURLConnection) urlToRequest.openConnection();
                InputStream in =
                        new BufferedInputStream(urlConnection.getInputStream());
                text = new Scanner(in).useDelimiter("\\A").next();*/
                Response res = client.newCall(request).execute();
                return res.body().string();
            } catch (Exception e) {
                return e.toString();
            } /*finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                } */
        }
        //return text

        @Override
        protected void onPostExecute(String results) {
            //JSONObject respJson = null;
            JSONArray json = null;
            Log.d("Fanny3", "HOLA");
            if(results == null)
            {
                Log.d("Fanny4", "HOLA");
            }
            if (results != null) {
                try{
                    json = new JSONArray(results);
                    for(int i = 0; i < json.length(); i++)
                    {
                        int price = Integer.parseInt(json.getJSONObject(i).get("price").toString());
                        mobiles.add(new Mobiles(json.getJSONObject(i).get("brand").toString(),
                                json.getJSONObject(i).get("name").toString(), price));
                    }

                    mAdapter = new uca.es.prueba.MobilesAdapter(mobiles);

                    mRecyclerView.setAdapter(mAdapter);
                }catch(JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
