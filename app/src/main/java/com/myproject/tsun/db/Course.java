package com.myproject.tsun.db;

/**
 * Created by 何书杰 on 2017/10/27.
 */

public class Course {
    private int imageId;
    private String courseName;
    private String courseFrom;
    public Course(int imageId,String courseName,String courseFrom){
        this.imageId = imageId;
        this.courseName = courseName;
        this.courseFrom = courseFrom;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseFrom() {
        return courseFrom;
    }
}
