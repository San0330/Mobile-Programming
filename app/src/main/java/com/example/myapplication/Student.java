package com.example.myapplication;

public class Student {
    private int sid;
    private String name;

    public Student(int sid, String name){
        this.sid = sid;
        this.name = name;
    }

    public int getSid(){
        return this.sid;
    }

    public String getName(){
        return this.name;
    }
}