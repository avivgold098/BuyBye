package com.example.goldav.buybye.model;

import java.util.List;

/**
 * Created by Aviv Gold on 6/13/2017.
 */

public class User {
    public String FirstName;
    public String LastName;
    public String pass;
    public String Email;
    public String Phone;
    public List<Item> items;

    public User()
    {
    }

    public void setUser( String FirstName, String LastName,String pass,String Email,String Phone)
    {
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.pass=pass;
        this.Email=Email;
        this.Phone=Phone;
    }


}
