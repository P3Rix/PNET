package uca.es.congress;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsersAdapter
        extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private ArrayList<Users> users;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView lastname;
        TextView dni;
        TextView telephone;
        TextView email;
        TextView start_date;
        TextView end_date;
        Button show;

        public MyViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            //lastname = (TextView) v.findViewById(R.id.lastname);
            dni = (TextView) v.findViewById(R.id.dni);
            telephone = (TextView) v.findViewById(R.id.telephone);
            email = (TextView) v.findViewById(R.id.email);
            start_date = (TextView) v.findViewById(R.id.startdate);
            end_date = (TextView) v.findViewById(R.id.enddate);
            show = (Button) v.findViewById(R.id.show);
        }
    }

    public UsersAdapter(ArrayList<Users> myDataset) {
        users = myDataset;
    }

    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(String.valueOf(users.get(position).getName()));
        //holder.lastname.setText(users.get(position).getLastname());
        holder.dni.setText(String.valueOf(users.get(position).getDni()));
        holder.telephone.setText(String.valueOf(users.get(position).getTelephone()));
        holder.email.setText(String.valueOf(users.get(position).getEmail()));
        holder.start_date.setText(String.valueOf(users.get(position).getStart_date()));
        holder.end_date.setText(String.valueOf(users.get(position).getEnd_date()));

        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "You've clicked on " + users.get(position).getName();
                int duration = Toast.LENGTH_LONG;
                //new MainActivity.LongRunningGetIO().execute();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


}