package com.example.cuongnguyen.gosleep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class CalendarAdapter extends BaseAdapter {
    Context myContex;
    int myLayout;
    List<Calendar> arrayTime;
    public CalendarAdapter(Context context, int layout, List<Calendar> calendarList){
        myContex = context;
        myLayout = layout;
        arrayTime = calendarList;

    }

    @Override
    public int getCount() {
        return arrayTime.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) myContex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout, null);
        TextView txtTimeStart=(TextView) convertView.findViewById(R.id.txtStart);
        txtTimeStart.setText((CharSequence) arrayTime.get(position).timeStart.toString());

        TextView txtTimeEnd=(TextView) convertView.findViewById(R.id.txtEnd);

        txtTimeEnd.setText((CharSequence) arrayTime.get(position).timeEnd.toString());

        TextView txtTimeNote=(TextView) convertView.findViewById(R.id.txtNote);

        txtTimeNote.setText((CharSequence) arrayTime.get(position).Content);

        TextView txtDate=(TextView) convertView.findViewById(R.id.txtDate);
        txtDate.setText((CharSequence) arrayTime.get(position).day.toString());


        return convertView;
    }
}
