package com.example.todolist;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {


    public static ArrayList<Task> getTasksByCategory(ArrayList<Task> myList, String category) {
        System.out.println("searching for tasks in category " + category);
        if (category.equals("work")) {
            for (Task t : myList) {
                t.printTask();
            }
            return myList;
            //return everything in myList where category = work
        } else if (category.equals("personal")) {
                     return myList;

        }
        return myList;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> myList = new ArrayList<Task>();
        boolean cont = true;

        System.out.println("Welcome to Your To Do List");
        System.out.println("--------------------------");

        while(cont) {
            System.out.println("Menu");
            System.out.println("    1. View all tasks");
            System.out.println("    2. View specific list");
            System.out.println("    3. Add a new task");
            System.out.println("    4. Check off task");
            System.out.println("    4. Edit existing task");
            System.out.println("    5. Change date for task");
            System.out.println("     Choose a number: ");


            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                System.out.println("All Tasks");
                System.out.println("------------------");
                System.out.println("Due  Task  Status?");
                System.out.println("---  ----  --------");
                for (Task t: myList){
                    t.printTask();
                }
            } else if (choice ==2) {
                System.out.println("View specific list");
                System.out.println("Which list would you like to view (work or personal)");
                String answer = scan.nextLine();
                //scan.nextLine();

                getTasksByCategory(myList, answer);




            } else if (choice ==3) {
                System.out.println("Add a new task");
                System.out.println("------------------");
                System.out.println("Describe your task: ");
                String description = scan.nextLine();
                System.out.println("Enter the date it is due: ");
                int due = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter your task category: (work or personal) ");
                String category = scan.nextLine();
                Task myTask = new Task(description, due, false, category);
                myList.add(myTask);

            }
            else if (choice ==4) {
                System.out.println("Check off task");
                System.out.println("All Tasks");
                System.out.println("------------------");
                System.out.println("Due  Task  Is Done?");
                System.out.println("---  ----  --------");
                for (Task t: myList){
                    t.printTask();
                    System.out.println("Is task done? (true = yes");
                    // if task is true delete it from lists

            } }
            else if (choice ==5) {
                System.out.println("Edit existing task");
            }else if (choice ==6) {
                System.out.println("Change date for task");
            }
            else {
                System.out.println("Invalid choice, try again.");
            }

            System.out.println("_______________________________________");
            System.out.println("Would you like to quit the application?");
            System.out.println("    1. Yes");
            System.out.println("    2. No");
            int quit = scan.nextInt();
            if (quit == 1) {
                cont = false;
            }

        }


    }

}
