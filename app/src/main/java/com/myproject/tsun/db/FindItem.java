package com.myproject.tsun.db;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class FindItem {
    private int imageId;
    private String itemName;

    public FindItem(int imageId,String itemName){
        this.imageId = imageId;
        this.itemName = itemName;
    }
    public int getImageId() {
        return imageId;
    }

    public String getItemName() {
        return itemName;
    }
}
