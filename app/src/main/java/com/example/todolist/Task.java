package com.example.todolist;

import java.util.ArrayList;

public class Task {

    //instance variables
    String task;
    int date;
    boolean isDone;
    String tag;
    String category;
    public static void main(String[] args) {
    }

   //constructor
    public Task() {
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

    public String printTask(){
        System.out.println("task name: " + task + "     it is due the " + date + "  of this month" + "\t"  + "status (is your task complete?) : " + isDone);
        return "task name: " + task + "     it is due the " + date + "  of this month" + "\t"  + "status (is your task complete?) : " + isDone;
    }

    public void editTask(String newTask){

        task = newTask;
    }

    public void editDate(int newDate){

        date = newDate;
    }

    public void editCategory(String newCategory){

        category = newCategory;
    }


}
