# ToDoList

--------------------------------------------------------About-----------------------------------------------------
Hello! Welcome to our To-Do List Program! Our names are Chea and Sam. We are currently seniors at Immaculate Heart High School! Our goal was to build a to do list manager in Java that would allow users to keep track of tasks throughout their month. Whether it be personal tasks or work related tasks, we wanted our program to be efficient and organized. 


----------------------------------------------------How To Use------------------------------------------------
The program is designed to make all task related functions extremely easy! Whether you want to edit, add, or delete,a task there is a number range from 1-7 designed for just that!

1. View all tasks
2. View specific list
3. Add a new task
4. Check off task
5. Change name of existing task
6. Change date of existing task
7. Create New To-Do List


Choose the number you would like to access (We recommend you start with number 3!). Everything else from there is pretty simple. 



------------------------------------------------Method Breakdowns-----------------------------------------

1. (getTasksByCategory, INCOMPLETE) 
Reads user input for View Specific List, will then display specific list 

2. (createTaskListFromFile, INCOMPLETE) 
Reads user input for Create New To-Do List, will then prompt for name of new list 

3.(replacePhrase, INCOMPLETE, NOT USED) 
intended to change “In Progress” to “Done,” but we decided to use Check Off Task instead. In the future, we would like to use replacePhrase which would allow users to specify whether a task is “Not Started” or “Incomplete

4. (printTask, COMPLETE) 
Is displayed when user chooses to “Read all tasks”. Reads user input for info about task (index, task, date, progress), then rearranged it to create an organized message about their task

5. (printTaskForFile, COMPLETE) 
Reads user input for info about task (index, task, date, progress). It outputs a much clearer, organized, and easy to read version of the user input. 

