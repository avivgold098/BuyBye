package com.example.goldav.buybye.model;

/**
 * Created by Aviv Gold on 6/14/2017.
 */

public class Item {
    public String itemName;
    public float price;
    public String title;
    public String location;
    public String imgUrl;

    public void SetItem(String itemName,float price,String title,String location,String imgUrl){
        this.itemName=itemName;
        this.imgUrl=imgUrl;
        this.price=price;
        this.location=location;
        this.title=title;
    }
}
