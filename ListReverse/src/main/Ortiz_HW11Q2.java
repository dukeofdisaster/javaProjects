/*
 * Description: Demonstrates the use of LinkedList to create a program for making
 * to-do lists. Task class creates task objects to be stored in the LinkedList
 * and uses the "importance" integer to rank tasks briority.
 *
 *

 * Completion Time: ~1hr
 *
 * Version: 1.0
 *
 */
package main;

/**
 *
 * @author joshortiz
 */
import java.util.LinkedList;

public class Ortiz_HW11Q2 {

  static class Task implements Comparable<Task> {

    private String taskName = "";
    private String dueDate = "";
    private String dueTime = "";
    private int importance = 0;

    public Task(String name, String date, String time, int imprt) {
      taskName = name;
      dueDate = date;
      dueTime = time;
      importance = imprt;
    }

    public String getName() {
      return taskName;
    }

    public String getDueDate() {
      return dueDate;
    }

    public String getDueTime() {
      return dueTime;
    }

    public int getImportance() {
      return importance;
    }

    @Override
    public int compareTo(Task t) {
      if (importance < t.getImportance()) {
        return 1;
      }
      if (taskName.equals(t.getName())) {
        return 0;
      } else if (importance > t.getImportance()) {
        return -1;
      } else {
        return -2;
      }
    }

    @Override
    public String toString() {
      String output = ("Name: " + taskName + " Date: "
              + dueDate + " Time: " + dueTime + " Importance: " + importance);
      return output;
    }
  }

  static interface ToDoListADT {

    public void add(Task t);

    public Task remove();

    public boolean isEmpty();

    public int size();
  }

  static class ToDoList implements ToDoListADT {

    LinkedList<Task> toDo = new LinkedList<Task>();

    @Override
    public void add(Task t) {
      toDo.addLast(t);
    }

    @Override
    public Task remove() {
      int biggest = 0;
      Task mostImportant = null;
      for (Task x : toDo) {
        if (x.getImportance() > biggest) {
          biggest = x.getImportance();
        }
      }
      for (Task y : toDo) {
        if (y.getImportance() == biggest) {
          mostImportant = y;
          toDo.remove(y);
        }
      }
      return mostImportant;
    }

    @Override
    public boolean isEmpty() {
      if (toDo.size() == 0) {
        return true;
      } else {
        return false;
      }
    }

    @Override
    public int size() {
      return toDo.size();
    }
  }

  public static void main(String[] args) {
    ToDoList toDoList = new ToDoList();
    Task t1 = new Task("Unit 11 Programming Assignment", "02/26/2016", "11:59 PM", 2);
    Task t2 = new Task("Mastering Physics: Chapter 5 Assignment", "02/24/2016", "11:59 PM", 3);
    Task t3 = new Task("Dentist Appointment", "03/05/2017", "2:30PM", 1);
    toDoList.add(t1);
    toDoList.add(t2);
    toDoList.add(t3);
    System.out.println(toDoList.remove());
    System.out.println(toDoList.remove());
    System.out.println(toDoList.remove());
  }
}
