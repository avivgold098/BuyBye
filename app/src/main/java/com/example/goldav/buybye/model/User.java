package com.example.goldav.buybye.model;

import java.util.List;

/**
 * Created by Aviv Gold on 6/13/2017.
 */

public class User {
    public String FirstName;
    public String LastName;
    public String Email;
    public String Phone;
    public List<Item> items;

    public User()
    {
    }

    public void setUser( String FirstName, String LastName,String Email,String Phone)
    {
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Email=Email;
        this.Phone=Phone;
    }


}
