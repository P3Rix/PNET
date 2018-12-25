package uca.es.congress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProgramAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Programa> listItems;

    public ProgramAdapter(Context context, ArrayList<Programa> listItems)
    {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount()
    {
        return listItems.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Programa item = (Programa) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.items, null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imageView_imagen);
        TextView horario = (TextView) convertView.findViewById(R.id.textView_superior);

        imgFoto.setImageResource(item.getImgFoto());
        horario.setText(item.getHorario());


        return convertView;
    }
}
