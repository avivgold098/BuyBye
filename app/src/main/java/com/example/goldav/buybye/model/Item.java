package com.example.goldav.buybye.model;

/**
 * Created by Aviv Gold on 6/14/2017.
 */

public class Item {
    public static int lastId=0;
    public Integer id;
    public String itemName;//
    public float price;//
    public String desc;//
    public String location;
    public String imgUrl;

    public void SetItem(String itemName,float price,String title,String location,String imgUrl,boolean add){
        this.itemName=itemName;
        this.imgUrl=imgUrl;
        this.price=price;
        this.location=location;
        this.desc=title;
        if(add)
        id=++lastId;
    }

}
