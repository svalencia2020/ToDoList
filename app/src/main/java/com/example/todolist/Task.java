package com.example.todolist;

import java.util.ArrayList;

public class Task {

    //instance variables
    String task;
    int date;
   // boolean isDone;
    String progress;
    String tag;
    String category;
    int index;

    public static void main(String[] args) {
    }

   //constructor
    public Task() {
        task = "default task";
        date = 0;
//        isDone = false;
        String progress = "unknown";
        tag = "all";
        index = 0;
    }

    public Task(String task, int d, String  cat, int i, String progress){
        this.task = task;
        date = d;
        index = i;
        category = cat;
        this.progress = progress;
    }


    //methods
//    public void checkDone(){
//        isDone = true;
//    }

    public String printTask(){

        System.out.println(index + ". You need to " + task + ". It is due on the " + date +  "th of this month." + "\t"  + " Your task is " + progress);
        return index + ". You need to " + task + ". It is due on the " + date +  "th of this month." + "\t"  + " Your task is " + progress;
    }

    public String printTaskForFile() {
        return index + "\t" + task + "\t" +  category + "\t" + date + "\t" + progress;
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
