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

//variables for task info
    public Task(String task, int d, String  cat, int i, String progress){
        this.task = task;
        date = d;
        index = i;
        category = cat;
        this.progress = progress;
    }


//METHODS

 //#4
    public String printTask(){

        System.out.println(index + ". You need to " + task + ". It is due on the " + date +  "th of this month." + "\t"  + " Your task is " + progress);
        return index + ". You need to " + task + ". It is due on the " + date +  "th of this month." + "\t" + " Your task is " + progress + ".";
    }

//#5
    public String printTaskForFile() {
        return index + "\t" + task + "\t" +  category + "\t" + date + "\t" + progress;
    }

//reads user input, changes the name of the task in the file to the new name, updates the variable
    public void editTask(String newTask){

        task = newTask;
    }

//reads user input, changes the date of the task in the file to the new date, updates the variable
    public void editDate(int newDate){

        date = newDate;
    }

//reads user input, changes the category of the task in the file to the new category, updates the variable
    public void editCategory(String newCategory){

        category = newCategory;
    }


}
