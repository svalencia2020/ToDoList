package com.example.todolist;

public class Task {

    //instance variables
    String task;
    int date;
    boolean isDone;
    String tag;


   //constructor
    public Task(){
        task = "default task";
        date = 0;
        isDone = false;
        tag = "all";
    }

    public Task(String t, int d, boolean done, String  ht){
        task = t;
        date = d;
        isDone = done;
        tag =  ht;
    }


    //methods
    public void checkDone(){
        isDone = true;
    }

    public void printTask(){
        System.out.println(date + "\t" + task + "\t"+ isDone);
    }

    public void editTask(String newTask){

        task = newTask;
    }

    public void editDate(int newDate){

        date = newDate;
    }



}
