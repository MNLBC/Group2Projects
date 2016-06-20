package W02M09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Worker implements Comparable<Object>{

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
   
   @Override
   public int compareTo(Object arg0) {
      Worker work = (Worker) arg0;
      int isEqual = ((Double) this.salary).compareTo(work.salary);
        
      return isEqual;
   }

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
      if ((age != other.age) || (!name.equals(other.name)) || 
         (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary)))
        {
         return false;
        }
    
      return true;
   }

}
