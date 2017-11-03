package com.myproject.tsun.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myproject.tsun.NewsContentActivity;
import com.myproject.tsun.R;
import com.myproject.tsun.db.News;

import java.util.List;

/**
 * Created by 何书杰 on 2017/10/31.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context mContext;
    private List<News> newsList;
    static class  ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView tv_newsFrom,tv_newsTime,tv_newsContent;
        ImageView iv_newsPic;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            iv_newsPic = (ImageView) view.findViewById(R.id.iv_newsPic);
            tv_newsFrom = (TextView) view.findViewById(R.id.tv_newsFrom);
            tv_newsTime = (TextView) view.findViewById(R.id.tv_newsTime);
            tv_newsContent = (TextView) view.findViewById(R.id.tv_newsContent);
        }
    }
    public NewsAdapter(List<News> mnewsList){
        newsList = mnewsList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.course_news_item,parent,false);
        final NewsAdapter.ViewHolder viewHolder = new NewsAdapter.ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                News news = newsList.get(position);
                mContext.startActivity(new Intent(mContext, NewsContentActivity.class));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.tv_newsContent.setText(news.getNewsContent());
        holder.tv_newsTime.setText(news.getNewsTime());
        holder.tv_newsFrom.setText(news.getNewsFrom());
        Glide.with(mContext).load(news.getImageId()).into(holder.iv_newsPic);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
