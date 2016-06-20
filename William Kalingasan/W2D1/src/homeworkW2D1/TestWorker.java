package homeworkW2D1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestWorker{

   public static void main(String[] args) {
      // Item 1
      List<Worker> workerList = new ArrayList<Worker>();
      workerList.add(new Worker("Simon",20,10000));
      workerList.add(new Worker("Jame",25,13000));
      workerList.add(new Worker("Alex",22,12000));
      System.out.println("ITEM 1\nNAME\tAGE\tSALARY");
      for(Worker work : workerList){
         System.out.println(work.getName() + "\t" + work.getAge() + "\t" + work.getSalary());
      }
      
      // Item 2
      workerList.add(1, new Worker("Steven",24,15000));
      System.out.println("\nITEM 2\nNAME\tAGE\tSALARY");
      for(Worker work : workerList){
         System.out.println(work.getName() + "\t" + work.getAge() + "\t" + work.getSalary());
      }
      
      // Item 3
      for(int i = 0; i < workerList.size(); i++){
         if(workerList.get(i).getName() == "Alex"){
            workerList.remove(i);
         }
      }
      
      // Item 4
      System.out.println("\nITEM 3 and 4\nNAME\tAGE\tSALARY");
      for(Worker work : workerList){
         System.out.println(work.getName() + "\t" + work.getAge() + "\t" + work.getSalary());
      }

      // Item 5
      System.out.println("\nITEM 5");
      Iterator iWorker = workerList.iterator();
      while(iWorker.hasNext()){
         Worker tempWorker = (Worker) iWorker.next();
         tempWorker.work();
      }
      
      // Item 6
      boolean value = new Worker("Test",1,10).equals(new Worker("Test",1,10));
      System.out.println("\nITEM 6\n" + value);
      
      
      // Item 7
      System.out.println("\nITEM 7");
      Map mapWorker = new HashMap<Double,String>();
      iWorker = workerList.iterator();
      while(iWorker.hasNext()){
         Worker tempWorker = (Worker) iWorker.next();
         mapWorker.put(tempWorker.getSalary(), tempWorker.getName());
      }
      Set keys = mapWorker.keySet();
      Iterator iKeys = keys.iterator();
      List<String> list = new ArrayList<String>();
      while(iKeys.hasNext()){
         Object key = iKeys.next();
         list.add("Name: " + mapWorker.get(key) + "\tSalary: " + key);
      }
      Collections.reverse(list);
      for(int i = 0; i < list.size(); i++){
         System.out.println(list.get(i));
      }
      
      // Item 8
      System.out.println("\nITEM 8-1");
      Map workMap = new HashMap<String,Worker>();
      for(int i = 0; i < workerList.size(); i++){
         workMap.put(String.valueOf(i), workerList.get(i));
      }
      keys = workMap.keySet();
      iKeys = keys.iterator();
      
      while(iKeys.hasNext()){
         Object key = iKeys.next();
         Worker tempWorker = (Worker) workMap.get(key);
         String name = tempWorker.getName();
         int age = tempWorker.getAge();
         double salary = tempWorker.getSalary();
         System.out.println("Worker ID: " + key + "\tName: " + name + "\tAge: " + age + "\tSalary: " + salary);
      }
      
      System.out.println("\nITEM 8-2");
      for(int i = 0; i < workerList.size();i++){
         Worker tempWorker = workerList.get(i);
         String name = tempWorker.getName();
         int age = tempWorker.getAge();
         double salary = tempWorker.getSalary();
         System.out.println("Worker ID: " + i + "\tName: " + name + "\tAge: " + age + "\tSalary: " + salary);
      }
      
      System.out.println("\nITEM 8-3");
      int i = 0;
      for(Worker work : workerList){
         String name = work.getName();
         int age = work.getAge();
         double salary = work.getSalary();
         System.out.println("Worker ID: " + i + "\tName: " + name + "\tAge: " + age + "\tSalary: " + salary);
         i++;
      }
      
   }

}
