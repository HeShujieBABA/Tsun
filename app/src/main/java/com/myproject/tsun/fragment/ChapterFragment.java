package com.myproject.tsun.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.myproject.tsun.R;
import com.myproject.tsun.adapter.MyExpandableAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class ChapterFragment extends Fragment {
    private ExpandableListView expandableListView;
    private  List<String> groupArray;
    private  List<List<String>> childArray;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter,container,false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.fragment_chapter_expandableListView);
        groupArray = new  ArrayList<String>();
        childArray = new  ArrayList<List<String>>();
        groupArray.add("第一章" );
        groupArray.add("第二章" );
        groupArray.add("第三章" );
        groupArray.add("第四章" );
        groupArray.add("第五章" );
        groupArray.add("第六章" );
        List<String> tempArray = new ArrayList<String>();
        tempArray.add("第一节" );
        tempArray.add("第二节" );
        tempArray.add("第三节" );
        tempArray.add("第四节" );
        tempArray.add("第五节" );
        tempArray.add("第六节" );
        for (int  index = 0 ; index <groupArray.size(); ++index)
        {
            childArray.add(tempArray);
        }
        MyExpandableAdapter myExpandableAdapter = new MyExpandableAdapter(getContext(),groupArray,childArray);
        expandableListView.setGroupIndicator(null);
        expandableListView.setAdapter(myExpandableAdapter);
        return view;
    }
}
