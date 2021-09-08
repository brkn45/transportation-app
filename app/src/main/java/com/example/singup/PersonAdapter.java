package com.example.singup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<User> user;
    private Context context;

    public PersonAdapter(Context context, ArrayList<User> user){
        this.context =context;
        this.user    =user;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int position) {
        return user.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = layoutInflater.inflate(R.layout.list,null);
        ImageView photo = (ImageView) customView.findViewById(R.id.PersonPhoto);
        TextView txtViewName   = (TextView)  customView.findViewById(R.id.txtListName);
        TextView txtViewCountry = (TextView) customView.findViewById(R.id.txtListCountry);

        photo.setImageResource(R.drawable.avatar);
        //String tmp = data.getUser(position).
        txtViewName.setText(user.get(position).getName()+ user.get(position).getGender());
        txtViewCountry.setText(user.get(position).getAddress());
        return customView;
    }
}
