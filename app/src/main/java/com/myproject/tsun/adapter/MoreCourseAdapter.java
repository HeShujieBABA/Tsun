package com.myproject.tsun.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.myproject.tsun.CourseContentActivity;
import com.myproject.tsun.R;
import com.myproject.tsun.db.MoreCourse;

import java.util.List;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class MoreCourseAdapter extends RecyclerView.Adapter<MoreCourseAdapter.ViewHolder>{
    private Context context;
    private List<MoreCourse> moreCourseList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView more_imageView;
        TextView more_tvCourseName,more_tvCourseTime,more_tvCourseFrom;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            more_imageView = (ImageView) view.findViewById(R.id.more_imageView);
            more_tvCourseName = (TextView) view.findViewById(R.id.more_tvCourseName);
            more_tvCourseTime = (TextView) view.findViewById(R.id.more_tvCourseTime);
            more_tvCourseFrom = (TextView) view.findViewById(R.id.more_tvCourseFrom);
        }
    }
    public MoreCourseAdapter(List<MoreCourse> mMoreCourseList){
        moreCourseList = mMoreCourseList;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MoreCourse moreCourse = moreCourseList.get(position);
        holder.more_tvCourseName.setText(moreCourse.getCourseName());
        holder.more_tvCourseTime.setText(moreCourse.getCourseTime());
        holder.more_tvCourseFrom.setText(moreCourse.getCourseFrom());
        Glide.with(context).load(moreCourse.getImageId()).into(holder.more_imageView);
    }

    @Override
    public int getItemCount() {
        return moreCourseList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.more_course_item,parent,false);
        final MoreCourseAdapter.ViewHolder viewHolder = new MoreCourseAdapter.ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                //指定哪个position
                MoreCourse moreCourse = moreCourseList.get(position);
                context.startActivity(new Intent(context, CourseContentActivity.class));
            }
        });
        return  viewHolder;
    }
}
