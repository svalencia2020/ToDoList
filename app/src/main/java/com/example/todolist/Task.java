package com.example.todolist;

import java.util.ArrayList;

public class Task {

    //instance variables
    String task;
    int date;
    boolean isDone;
    String tag;
    String category;
    int index;

    public static void main(String[] args) {
    }

   //constructor
    public Task() {
        task = "default task";
        date = 0;
        isDone = false;
        tag = "all";
        index = 0;
    }

    public Task(String t, int d, boolean done, String  ht, int i){
        task = t;
        date = d;
        isDone = done;
        tag =  ht;
        index = i;
    }


    //methods
    public void checkDone(){
        isDone = true;
    }

    public String printTask(){
//        System.out.println(index + "    task name: " + task + "     it is due the " + date + "  of this month" + "\t"  + "In Progress? : " + isDone);
//        return "task name: " + task + "     it is due the " + date + "  of this month" + "\t"  + "In Progress? : " + isDone;

        System.out.println(index + " " + task + "       it is due the " + date +  "\t"  + "  In Progress? : " + isDone);
        return index + " " + task + "       it is due the " + date +  "\t"  + "  In Progress? : " + isDone;
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
