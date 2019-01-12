package com.example.cuongnguyen.gosleep;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class CustomAdapter  extends ArrayAdapter<MyCalendar>{
     private Context context;
     private int resource;
     private List<MyCalendar> studentList;
            public CustomAdapter(@NonNull Context context, int resource, @NonNull MyCalendar[] objects) {
                super(context, resource, objects);
                this.context =context;
                this.resource=resource;
                this.studentList= Arrays.asList(objects);
            }


    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView, @NonNull ViewGroup parent) {
                ViewHolder viewHolder;
                if (convertView==null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.edit_time,parent,false);
                    viewHolder = new ViewHolder();
                    viewHolder.tvId = (TextView)convertView.findViewById(R.id.txtId);
                    viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.txtNote);
                    viewHolder.tvContent = (TextView)convertView.findViewById(R.id.txtContent);
                    viewHolder.tvDate = (TextView)convertView.findViewById(R.id.txtDate);
                    viewHolder.tvTimeStart = (TextView)convertView.findViewById(R.id.txtStart);
                    viewHolder.tvTimeEnd = (TextView)convertView.findViewById(R.id.txtEnd);

                    convertView.setTag(viewHolder);
                }else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                MyCalendar student =studentList.get(position);
                viewHolder.tvId.setText(String.valueOf(student.getId()));
                viewHolder.tvTitle.setText(student.getTitle());
                viewHolder.tvContent.setText(student.getContent());
                viewHolder.tvDate.setText(student.getDayformat());
                viewHolder.tvTimeStart.setText(student.getTimeStartformat());
                viewHolder.tvTimeEnd.setText(student.getTimeEndformat());
        return convertView;
    }
    public  class ViewHolder{
                private TextView tvId;
                private TextView tvTitle;
                private TextView tvDate;
                private TextView tvTimeStart;
                private TextView tvTimeEnd;
                private TextView tvContent;

    }
}
