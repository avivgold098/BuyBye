package com.example.goldav.buybye.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aviv Gold on 6/18/2017.
 */

public class ModelFirebase {
    public void addUser(User user) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("students");
        Map<String, Object> value = new HashMap<>();
        value.put("FirstName", user.FirstName);
        value.put("LastName", user.LastName);
        value.put("UserName",user.userName);
        value.put("Email", user.Email);
        value.put("Phone", user.Phone);
        value.put("items",user.items);
        value.put("lastUpdateDate", ServerValue.TIMESTAMP);
        myRef.child(user.userName).setValue(value);
    }
}
