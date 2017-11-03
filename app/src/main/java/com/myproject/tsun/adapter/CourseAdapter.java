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

import com.bumptech.glide.Glide;
import com.myproject.tsun.CourseContentActivity;
import com.myproject.tsun.R;
import com.myproject.tsun.db.Course;
import com.myproject.tsun.db.MoreCourse;

import java.util.List;

/**
 * Created by 何书杰 on 2017/10/27.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    private Context mContent;
    private List<Course> mCourseList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView item_courseName,item_courseFrom;
        ImageView item_courseImageView;
       public ViewHolder(View view){
           super(view);
           cardView = (CardView) view;
           item_courseImageView = (ImageView) view.findViewById(R.id.item_imageView);
           item_courseName = (TextView) view.findViewById(R.id.item_courseName);
           item_courseFrom = (TextView) view.findViewById(R.id.item_courseFrom);
       }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = mCourseList.get(position);
        holder.item_courseName.setText(course.getCourseName());
        holder.item_courseFrom.setText(course.getCourseFrom());
        Glide.with(mContent).load(course.getImageId()).into(holder.item_courseImageView);
    }
    public CourseAdapter(List<Course> CourseList){
        mCourseList = CourseList;
    }
    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContent == null){
            mContent = parent.getContext();
        }
        View view = LayoutInflater.from(mContent).inflate(R.layout.course_item_layout,parent,false);
        final CourseAdapter.ViewHolder viewHolder = new CourseAdapter.ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Course course = mCourseList.get(position);
                mContent.startActivity(new Intent(mContent, CourseContentActivity.class));
            }
        });
        return viewHolder;
    }
}
