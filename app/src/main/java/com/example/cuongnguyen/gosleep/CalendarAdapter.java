package com.example.cuongnguyen.gosleep;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import android.view.LayoutInflater;


public class CalendarAdapter extends ArrayAdapter<MyCalendar> {
    private Context context;
    private int resource;
    private List<MyCalendar> calenderList;
    private OnEditClickListener listener;


    public CalendarAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MyCalendar> objects, OnEditClickListener listeners ) {
            super(context, resource, objects);
            this.context =context;
            this.resource=resource;
            this.calenderList= objects;
            this.listener = listeners;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.detail_time,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView)convertView.findViewById(R.id.txt_id);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.txtNote);
            viewHolder.tvDate = (TextView)convertView.findViewById(R.id.txtDate);
            viewHolder.tvTimeStart = (TextView)convertView.findViewById(R.id.txtStart);
            viewHolder.tvTimeEnd = (TextView)convertView.findViewById(R.id.txtEnd);

            convertView.setTag(viewHolder);
            }else {
            viewHolder = (ViewHolder) convertView.getTag();
            }
            MyCalendar calendar =calenderList.get(position);

            final int posid = calendar.getId();
            viewHolder.tvTitle.setText(calendar.getTitle());
            viewHolder.tvDate.setText(calendar.getDayformat());
            viewHolder.tvTimeStart.setText(calendar.getTimeStartformat());
            viewHolder.tvTimeEnd.setText(calendar.getTimeEndformat());
            ImageView editimg = (ImageView) convertView.findViewById(R.id.edit);

            editimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("linh","edit");
                    listener.onEditClick(position,posid );
                }
            });
            ImageView deleteimg = (ImageView) convertView.findViewById(R.id.trash);

            deleteimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("linh","trash");
                    System.out .println("possition1 :" +position);
                    System.out .println("possition 2: " +posid);
                    listener.onDeleteClick(position,posid);

            }
        });
            return convertView;

    }
    public interface OnEditClickListener{
        void onEditClick(int position, int positionID );
        void onDeleteClick (int position,int positionID);

    }
public  class ViewHolder{
    private TextView tvId;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvTimeStart;
    private TextView tvTimeEnd;

}
}
