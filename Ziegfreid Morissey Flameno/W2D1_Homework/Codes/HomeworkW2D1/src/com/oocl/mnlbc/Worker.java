package com.oocl.mnlbc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Worker implements Comparable<Object> {

   private int age;
   private String name;
   private double salary;

   public Worker() {
   }

   public Worker(String name, int age, double salary) {
      this.name = name;
      this.age = age;
      this.salary = salary;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public void work() {
      System.out.println(name + " is working");
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // #1 Create a List
      List<Worker> workers = new ArrayList<Worker>();
      workers.add(new Worker("Simon", 20, 10000));
      workers.add(new Worker("Jame", 25, 13000));
      workers.add(new Worker("Alex", 22, 12000));

      // #2 Add One Worker before Jame
      workers.add(1, new Worker("Steven", 24, 15000));

      // #3 Remove the worker Alex's Info
      workers.remove(3);

      // #4 Print out workers info using For
      System.out.println("For Loop:");
      for (Worker w : workers) {
         System.out.print(w.name + " ");
         System.out.print(w.age + " ");
         System.out.print(w.salary + "\n");
      }

      // #5 Print out work method using iterator
      System.out.println("\nIterator:");
      Iterator<Worker> i = workers.iterator();
      while (i.hasNext()) {
         Worker w = (Worker) i.next();
         w.work();
      }

      // #7 Sort all workers from high to low by salary (see also compareTo below)
      Collections.sort(workers);
      Collections.reverse(workers);
      System.out.println("\nSorted:");
      for (Worker w : workers) {
         System.out.print(w.name + " ");
         System.out.print(w.age + " ");
         System.out.print(w.salary + "\n");
      }

      // #8 Add Id to Worker Class and save to workMap
      Map<String, Worker> workMap = new HashMap<String, Worker>();
      for (int j = 0; j < workers.size(); j++) {
         workMap.put(String.valueOf(j), workers.get(j));
      }

      System.out.println("\nWorkMap:");
      System.out.println("For Loop (with index): ");
      for (int k = 0; k < workMap.size(); k++) {
         System.out.println("Worker Id: " + k + " Name: " + workMap.get(String.valueOf(k)).getName() + " Age: "
            + workMap.get(String.valueOf(k)).getAge() + " Salary: " + workMap.get(String.valueOf(k)).getSalary());
      }
      System.out.println("\nFor Loop (without index): ");
      for (Map.Entry<String, Worker> entry : workMap.entrySet()) {
         System.out.println("Worker Id: " + entry.getKey() + " Name: " + entry.getValue().getName() + " Age: "
            + entry.getValue().getAge() + " Salary: " + entry.getValue().getSalary());
      }
      System.out.println("\nIterator: ");
      Iterator<String> wi = workMap.keySet().iterator();
      while (wi.hasNext()) {
         String key = (String) wi.next();
         Worker wr = workMap.get(key);
         System.out.println("Worker Id: " + key + " Name: " + wr.name + " Age: " + wr.age + " Salary: " + wr.salary);
      }
   }

   // #6 Over write equals method of class Worker
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      long temp;
      temp = Double.doubleToLongBits(salary);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Worker other = (Worker) obj;
      if (age != other.age)
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
         return false;
      return true;
   }

   // #7 override compareTo
   @Override
   public int compareTo(Object o) {
      // TODO Auto-generated method stub
      Worker w = (Worker) o;
      return ((Double) this.salary).compareTo(w.salary);
   }
}
