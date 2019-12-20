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
//ALL NUMBERS ON METHODS CORRESPOND WITH READ ME FILE (MORE SPECIFIC INFO ON FILE)

// #1
    private static ArrayList<Task> getTasksByCategory(ArrayList<Task> myList, String category) {
        System.out.println("Searching for tasks in category: " + category);
        ArrayList<Task> specificList = new ArrayList<Task>();
        for (Task t : myList) {
            if (t.category.equals(category)) {
                specificList.add(t);
            }
        }

        return specificList;
    }

    // #2
    public static void createTaskListFromFile() throws FileNotFoundException {
        System.out.println("creating list from file");
        Scanner s = new Scanner(new File("MasterToDoList.txt")).useDelimiter(System.lineSeparator());
        ArrayList<Task> list = new ArrayList<Task>();
        while (s.hasNextLine()) {
            String[] a = s.nextLine().split("\t");
            list.add(new Task(a[1], Integer.parseInt(a[3]), a[2], Integer.parseInt(a[0]), a[4]));
        }
        for (Task t:list) {
            System.out.println(t.printTask());
        }


    }

// #3
    @TargetApi(Build.VERSION_CODES.O)
    public static void replacePhrase(String fileName, String target, String replacement, String toFileName) throws IOException {
        Path path = Paths.get(fileName);
        Path toPath = Paths.get(toFileName);
        System.out.println(path);
        Charset charset = Charset.forName("UTF-8");
        FileWriter fw = new FileWriter(toFileName, true);
        BufferedWriter writer = new BufferedWriter(fw);
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

    @TargetApi(Build.VERSION_CODES.O)
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileOutputStream out = null;
        ArrayList<Task> myList = new ArrayList<Task>();
        boolean cont = true;
        int count = 0;

//Introduction to User
        System.out.println("Welcome to Your To Do List");
        System.out.println("--------------------------");

//Displays options for user to interact with ToDo List
        while(cont) {
            System.out.println("Menu");
            System.out.println("    1. View all tasks");
            System.out.println("    2. View specific list");
            System.out.println("    3. Add a new task");
            System.out.println("    4. Check off task");
            System.out.println("    5. Change name of existing task");
            System.out.println("    6. Change date of existing task");
            System.out.println("    7. Create New To-Do List");
            System.out.println(" Choose a number: ");



            int choice = scan.nextInt();
            scan.nextLine();

 //If user chooses #1, this will display
  //allows user to view all tasks (no matter the category)
            if (choice == 1) {
                System.out.println("All Tasks");
                System.out.println("------------------");
                for (Task task: myList){
                    task.printTask();
                }

//If user chooses #2, this will display
//allows user to view a specific task
            } else if (choice ==2) {
                System.out.println("View specific list");
                System.out.println("Which list would you like to view (Work or Personal)");
                String answer = scan.nextLine();
                //scan.nextLine();

                getTasksByCategory(myList, answer);

//If user chooses #3, this will display
//allows user to create new task
            } else if (choice ==3) {
                System.out.println("Add a new task");
                System.out.println("------------------");
                System.out.println("What do you need to complete? (ex. Clean Room): ");
                String description = scan.nextLine();
                System.out.println("Enter the day it is due (ex. 12): ");
                int due = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter your task category (Work or Personal): ");
                String category = scan.nextLine();
                System.out.println("Is the task in progress? (If yes, (in Progress). If no, (done)");
                String progress = scan.nextLine();

//reads user input about task and stores in MasterToDoList file
                count ++;
                Task myTask = new Task(description, due, category, count, progress);
                // add task to list
                myList.add(myTask);
                //add task to file
                FileWriter fw = new FileWriter("MasterToDoList.txt", true);
                BufferedWriter writer = new BufferedWriter(fw);
                String line = myTask.printTaskForFile();
                writer.write(line);
                writer.newLine();
                writer.close();

            }

  //If user chooses #4, this will display
  //Allows user to delete task (check off)
            else if (choice ==4) {
                System.out.println("Check off task");
//edit task in array
                System.out.println("All Tasks");
                System.out.println("------------------");
                for (Task task: myList){
                    task.printTask();

                }

                System.out.println("What task would you like to check off? (choose the task number)");
                int checkOff = scan.nextInt();
                for (int i = 0; i < myList.size(); i++){
                    myList.get(i).printTask();
                    if(checkOff == myList.get(i).index){
                        myList.remove(i);
                    }
                }
                //then delete that line from file

//replace in file - move to changing a specific task to in progress
                try {
//DO NOT KNOW HOW TO CHANGE HARD-CODED FILE PATHS TO MAKE GENERAL
                    replacePhrase("/Users/cwright2020/Desktop/ToDoList/ToDoList/app/src/main/java/com/example/todolist/MasterToDoList.txt", "In Progress", "Done", "/Users/cwright2020/Desktop/ToDoList/ToDoList/app/src/main/java/com/example/todolist/hw11testchanged.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//If user chooses #5, this will display
//allows user to edit name (of existing task)
            else if (choice ==5) { //make ur text say edit name
                System.out.println("Edit task name");
                for (Task task: myList){
                    task.printTask();

                }

                System.out.println("What task would you like to edit? (choose the number) ");
               int edit = scan.nextInt();
                scan.nextLine();
                System.out.println("Please type in your new task name.");
                String nTask = scan.nextLine();
                for (int i = 0; i < myList.size(); i++){
                    if(edit == myList.get(i).index){
                       myList.get(i).task = nTask;
                        myList.get(i).printTask();
                    }
                }


//If user chooses #6, this will display
//allows user to change the date in a specific task
            }else if (choice ==6) {
                System.out.println("Change date for task");
                for (Task task: myList){
                    task.printTask();

                }
                System.out.println("What task would you like to edit? (choose the number) ");
                int editDate = scan.nextInt();
                System.out.println("Please type in your new date");
                int nDate = scan.nextInt();
                for (int i = 0; i < myList.size(); i++){
                    if(editDate == myList.get(i).index){
                        myList.get(i).date = nDate;
                        myList.get(i).printTask();
                    }
                }


//If user chooses #7, this will display
// allows user to create new to do list
            } else if (choice ==7) {
                System.out.println("Create New To-Do List");
                System.out.println("Please enter your to do list name.");
                createTaskListFromFile();
                String fileName = scan.nextLine();
                try {
                    out = new FileOutputStream(fileName + ".txt");
                    out.write((fileName + " To Do List\n").getBytes());
                    out.write("----------------------------".getBytes());
                } catch (IOException x){
                    System.out.println(x);
                }

            } else {

                System.out.println("Invalid choice, try again.");
            }
//Allows users to continue interacting with program, or choose to "quit" which will finish the process (with exit code 0)
 // if user chooses to continue, the menu will be displayed again and they will be prompted to choose a action
            System.out.println("_______________________________________");
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
