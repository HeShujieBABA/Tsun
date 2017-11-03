package com.myproject.tsun.db;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class MoreCourse {
    private int imageId;
    private String courseName;
    private String courseTime;
    private String courseFrom;
    public MoreCourse(int imageId,String courseName,String courseTime,String courseFrom){
        this.imageId = imageId;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseFrom = courseFrom;
    }
    public int getImageId() {
        return imageId;
    }

    public String getCourseFrom() {
        return courseFrom;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }
}
