package com.example.todolist;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ToDoList {

    public static void storeTextFile() throws FileNotFoundException {
        System.out.println("creating from file");
        Scanner s = new Scanner(new File("hw11test.txt")).useDelimiter(System.lineSeparator());
        System.out.println(s.hasNext());
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            System.out.println("s");
            list.add(s.nextLine());
        }
        for (String st:list) {
            System.out.println(st);
        }

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
            System.out.println("    5. Edit existing task");
            System.out.println("    6. Change date for task");
            System.out.println("    7. Create New To-Do List");
            System.out.println(" Choose a number: ");


            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                System.out.println("All Tasks");
                System.out.println("------------------");
                for (Task t: myList){
                    t.printTask();
                }
            } else if (choice ==2) {
                System.out.println("View specific list");
            } else if (choice ==3) {
                System.out.println("Add a new task");
                System.out.println("------------------");
                System.out.println("Desribe your task: ");
                String description = scan.nextLine();
                System.out.println("Enter your due date: ");
                int due = scan.nextInt();
                System.out.println("Enter your task category: ");
                String category = scan.nextLine();
                Task myTask = new Task(description, due, false, category);
                myList.add(myTask); 

            } else if (choice ==4) {
                System.out.println("Check off task");
            } else if (choice ==5) {
                System.out.println("Edit existing task");
            }else if (choice ==6) {
                System.out.println("Change date for task");
            }else if (choice ==7) {
                System.out.println("Create New To-Do List");
                try {
                    storeTextFile();
                } catch (FileNotFoundException e) {

                }

            } else {
                System.out.println("Invalid choice, try again.");
            }

            System.out.println("Would you like to quit the application?");
            System.out.println("    1. Yes");
            System.out.println("    2. No");
            int quit = scan.nextInt();
            if (quit == 1) {
                scan.close();
                cont = false;
            }

        }


    }

}
