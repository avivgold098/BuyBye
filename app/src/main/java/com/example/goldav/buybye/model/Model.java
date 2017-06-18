package com.example.goldav.buybye.model;

/**
 * Created by Aviv Gold on 6/18/2017.
 */

public class Model {
    public final static Model instace = new Model();

   // private ModelSql modelSql;
    private ModelFirebase modelFirebase;

    private Model() {
        //modelMem = new ModelMem();
      //  modelSql = new ModelSql(MyApplication.getMyContext());
        modelFirebase = new ModelFirebase();

    }
    public void addUser(User user) {
        //StudentSql.addStudent(modelSql.getWritableDatabase(),st);
        modelFirebase.addUser(user);
    }
}
