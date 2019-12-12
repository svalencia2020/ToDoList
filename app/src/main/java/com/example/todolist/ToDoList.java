package com.example.todolist;
import android.annotation.TargetApi;
import android.os.Build;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.*;

public class ToDoList {

    //METHOD 1
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

    //METHOD 2
    @TargetApi(Build.VERSION_CODES.O)
    public static void replacePhrase(String fileName, String target, String replacement, String toFileName) throws IOException {
        Path path = Paths.get(fileName);
        Path toPath = Paths.get(toFileName);
        System.out.println(path);
        Charset charset = Charset.forName("UTF-8");
        BufferedWriter writer = Files.newBufferedWriter(toPath, charset);
        Scanner scanner = new Scanner(path, charset.name());
        String line;
        while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                System.out.println(line);
                line = line.replaceAll( target, replacement);
                writer.write(line);
                writer.newLine();
        }
        scanner.close();
        writer.close();
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
                try {
                    replacePhrase("/Users/cwright2020/Desktop/ToDoList/ToDoList/app/src/main/java/com/example/todolist/hw11test.txt", "In Progress", "Done", "/Users/cwright2020/Desktop/ToDoList/ToDoList/app/src/main/java/com/example/todolist/hw11testchanged.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
