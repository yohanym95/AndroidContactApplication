package com.example.yohan.fragmentrecyclertest;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();
        people = new ArrayList<Person>();

        people.add(new Person("Yohan","0710000000"));
        people.add(new Person("Malsha","0711111111"));
        people.add(new Person("Dilan","07122222222"));

    }
}
