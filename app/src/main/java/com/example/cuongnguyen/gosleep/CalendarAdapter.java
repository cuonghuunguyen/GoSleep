package com.example.cuongnguyen.gosleep;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class CalendarAdapter extends BaseAdapter {
    Context myContex;
    int myLayout;
    List<MyCalendar> arrayTime;

    private OnEditClickListener listener;





    public CalendarAdapter(Context context, int layout, List<MyCalendar> calendarList, OnEditClickListener listeners){
        myContex = context;
        myLayout = layout;
        listener = listeners;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

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

        ImageView editimg = (ImageView) convertView.findViewById(R.id.edit);

        editimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("linh","edit");
              //  ShowCalendarActivity show = new ShowCalendarActivity();
                listener.onEditClick();
            }
        });
        ImageView deleteimg = (ImageView) convertView.findViewById(R.id.trash);

        deleteimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("linh","trash");
            }
        });

        return convertView;
    }
    public interface OnEditClickListener{
        void onEditClick();
        void onDeleteClick (int pos);

    }
}
