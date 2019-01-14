package com.example.pnet.ejemplo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter
        extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private ArrayList<User> users;
    private Context context;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView dni;
        TextView email;


        public MyViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            dni = (TextView) v.findViewById(R.id.dni);
            email = (TextView) v.findViewById(R.id.email);
        }
    }

    public UserAdapter(ArrayList<User> myDataset) {
        users = myDataset;
    }

    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(String.valueOf(users.get(position).getName()));
        holder.dni.setText(String.valueOf(users.get(position).getDni()));;
        holder.email.setText(String.valueOf(users.get(position).getEmail()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


}
