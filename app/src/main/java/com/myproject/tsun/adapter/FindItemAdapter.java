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
import com.myproject.tsun.NewsContentActivity;
import com.myproject.tsun.R;
import com.myproject.tsun.ServiceActivity;
import com.myproject.tsun.db.FindItem;

import java.util.List;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class FindItemAdapter extends RecyclerView.Adapter<FindItemAdapter.ViewHolder>{
    private Context context;
    private List<FindItem> findItemList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView findFragment_iv_picItem;
        TextView findFragment_tv_nameItem;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            findFragment_iv_picItem = (ImageView) view.findViewById(R.id.findFragment_iv_picItem);
            findFragment_tv_nameItem = (TextView) view.findViewById(R.id.findFragment_tv_nameItem);
        }
    }
    public FindItemAdapter(List<FindItem> mfindItemList){
        findItemList = mfindItemList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.find_item_layout,parent,false);
        final FindItemAdapter.ViewHolder viewHolder = new FindItemAdapter.ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                switch (position){
                    case 0:
                        FindItem findItem_0 = findItemList.get(0);
                        break;
                    case 1:
                        FindItem findItem_1 = findItemList.get(1);
                        break;
                    case 2:
                        FindItem findItem_2 = findItemList.get(2);
                        break;
                    case 3:
                        FindItem findItem_3 = findItemList.get(3);
                        context.startActivity(new Intent(context, ServiceActivity.class));
                        break;
                    case 4:
                        FindItem findItem_4 = findItemList.get(4);
                        context.startActivity(new Intent(context, NewsContentActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FindItem findItem = findItemList.get(position);
        holder.findFragment_tv_nameItem.setText(findItem.getItemName());
        Glide.with(context).load(findItem.getImageId()).into(holder.findFragment_iv_picItem);
    }

    @Override
    public int getItemCount() {
        return findItemList.size();
    }
}
