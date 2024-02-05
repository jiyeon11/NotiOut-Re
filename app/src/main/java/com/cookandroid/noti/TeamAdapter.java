package com.cookandroid.noti;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class TeamAdapter extends ArrayAdapter<Team> {
    public TeamAdapter(Context context, List<Team> teams){
        super(context,0,teams);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Team team = getItem(position);

        ImageView logo = convertView.findViewById(R.id.logo);
        TextView name = convertView.findViewById(R.id.name);

        logo.setImageDrawable(ContextCompat.getDrawable(getContext(), team.getLogoResId()));
        name.setText(team.getName());

        return convertView;
    }
}