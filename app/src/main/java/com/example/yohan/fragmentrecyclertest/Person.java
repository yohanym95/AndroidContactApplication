package com.example.yohan.fragmentrecyclertest;

public class Person {

    private String name;
    private String TelNumber;

    public Person(String name, String telNumber) {
        this.name = name;
        TelNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return TelNumber;
    }

    public void setTelNumber(String telNumber) {
        TelNumber = telNumber;
    }
}
