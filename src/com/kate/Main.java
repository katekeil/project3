/*Modify your code from Project 2 so that the class representing tasks implements
the appropriate interface allowing tasks to be sorted based first on
their priority than on their name.  If two tasks have different priorities,
the task with the greater priority appears before the other task.  If two
tasks have the same priority, then the task whose name would appear first
alphabetically appears before the other task.  If two tasks have the same
priority and their names are the same, then they are "equal" with regard to
the comparison.

Additionally, modify the code from Project 2 to include a custom class
representing a collection of tasks.  This class should implement the
appropriate interface so that a for-each loop can be used to iterate through
all the tasks.  The order in which the tasks are returned for the for-each loop
is up to you.

Test this new functionality.


Be sure to commit your code and push it to GitHub.  If you would like to
work in teams, use forks and pull requests; individual team members should
submit links to their fork of the repository.

Points will be assigned as follows:

No syntax errors: 5 points
Correctly implements the necessary interface to support for-each loops: 10 points
Correctly implements the necessary interface to support sorting: 10 points
*/

package com.kate;

import java.util.*;
import java.util.Iterator;
import java.util.Collections;

public class Main {

    private static TaskCollection taskCollection = new TaskCollection();
    private static boolean running = true;
    private static Scanner scan = new Scanner(System.in);

    private static void displayMenu(){ //Display menu and ask for a menu option every loop

        System.out.println("What would you like to do?");
        System.out.println("(1)- Add task. ");
        System.out.println("(2)- Remove task. ");
        System.out.println("(3)- Edit a task.");
        System.out.println("(4)- View full to-do list.");
        System.out.println("(5) List Tasks according to priority");
        System.out.println("(0)- Exit ");


        String input = scan.nextLine();

        switch(input){
            case "1": taskCollection.addTask(); //Run add task method in taskList
                break;
            case "2": taskCollection.remTask(); //Run remove task method in taskList
                break;
            case "3": taskCollection.editTask(); //Run edit task method in taskList
                break;
            case "4":
                Collections.sort(taskCollection.taskCollection);
                for(Task task: taskCollection) {
                    System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
                }//Run list task method in taskList
                break;
            case "5": taskCollection.listTasksPriority(); //Run listTaskPriority method in taskList
                break;
            case "0": running=false; //Exit program
                break;
            default:
                System.out.println("Invalid input. Please try again, enter an integer value (1-5 or 0 to exit)"); //Invalid input
        }
    }
    public static void main(String[] args) {

        while(running){ //While program is running, keep asking for options
            displayMenu();
        }
    }
}
