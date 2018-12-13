package uca.es.prueba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uca.es.prueba.MainActivity;
import uca.es.prueba.Mobiles;
import uca.es.prueba.Pokemon;
import uca.es.prueba.R;

public class MobilesAdapter
        extends RecyclerView.Adapter<MobilesAdapter.MyViewHolder> {

    private ArrayList<Mobiles> pokemons;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        TextView name;
        TextView price;
        Button show;

        public MyViewHolder(View v) {
            super(v);
            number = (TextView) v.findViewById(R.id.number);
            name = (TextView) v.findViewById(R.id.name);
            price = (TextView) v.findViewById(R.id.price);
            show = (Button) v.findViewById(R.id.show);
        }
    }

    public MobilesAdapter(ArrayList<Mobiles> myDataset) {
        pokemons = myDataset;
    }

    @Override
    public MobilesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.number.setText(String.valueOf(pokemons.get(position).getBrand()));
        holder.name.setText(pokemons.get(position).getName());
        holder.price.setText(String.valueOf(pokemons.get(position).getPrice()));

        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "You've clicked on " + pokemons.get(position).getName();
                int duration = Toast.LENGTH_LONG;
                //new MainActivity.LongRunningGetIO().execute();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }


}
