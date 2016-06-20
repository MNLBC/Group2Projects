package w2d1hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      // Item #1
      System.out.println("\nItem #1");
      List<Worker> workers = new ArrayList();

      workers.add(new Worker("Simon", 20, 10000));
      workers.add(new Worker("Jame", 25, 13000));
      workers.add(new Worker("Alex", 22, 12000));

      System.out.println("Name \t \t Age \t \t Salary");

      for (Worker work : workers) {
         System.out.println(work.getName() + "\t \t" + work.getAge() + "\t \t" + work.getSalary());
      }

      // Item #2
      System.out.println("\nItem #2");
      int x = 0;
      for (int i = 0; i < workers.size(); i++) {
         Worker work = (Worker) workers.get(i);
         if (work.getName() == "Jame") {
            x = i;
         }
      }
      workers.add(x, new Worker("Steven", 24, 15000));

      System.out.println("Name \t \t Age \t \t Salary");

      for (Worker work : workers) {
         System.out.println(work.getName() + "\t \t" + work.getAge() + "\t \t" + work.getSalary());
      }

      // Item #3
      System.out.println("\nItem #3");
      int y = 0;
      for (int i = 0; i < workers.size(); i++) {
         Worker work = (Worker) workers.get(i);
         if (work.getName() == "Alex") {
            y = i;
         }
      }
      workers.remove(y);

      System.out.println("Name \t \t Age \t \t Salary");

      for (Worker work : workers) {
         System.out.println(work.getName() + "\t \t" + work.getAge() + "\t \t" + work.getSalary());
      }

      // Item #4
      System.out.println("\nItem #4");
      System.out.println("Name \t \t Age \t \t Salary");
      Iterator it = workers.iterator();
      while (it.hasNext()) {
         Worker worker = (Worker) it.next();
         System.out.println(worker.getName() + "\t \t" + worker.getAge() + "\t \t" + worker.getSalary());
      }

      // Item #5
      System.out.println("\nItem #5");
      it = workers.iterator();
      while (it.hasNext()) {
         Worker worker = (Worker) it.next();
         worker.work();
      }

      // Item #7
      System.out.println("\nItem #7");
      Collections.sort(workers, new Comparator<Worker>() {

         public int compare(Worker worker1, Worker worker2) {
            double salary1 = worker1.getSalary();
            double salary2 = worker2.getSalary();

            if (salary1 > salary2) {
               return -1;
            }
            if (salary2 > salary1) {
               return 1;
            } else {
               return 0;
            }
         }
      });
      for (Worker work : workers) {
         System.out.println("Name: " + work.getName() + " Salary: " + work.getSalary());
      }

      // Item #8
      System.out.println("\nItem #8");
      System.out.println("\nWay #1");
      Map workMap = new HashMap<String, Worker>();
      for (int i = 0; i < workers.size(); i++) {
         Worker employee = (Worker) workers.get(i);
         workMap.put(String.valueOf(i), employee);
      }

      // Item #8.1
      for (int i = 0; i < workMap.size(); i++) {
         Worker wrkr = (Worker) workMap.get(String.valueOf(i));
         System.out.println(
            "Worker ID: " + i + " Name: " + wrkr.getName() + " Age: " + wrkr.getAge() + " Salary: " + wrkr.getSalary());
      }

      // Item #8.2
      System.out.println("\nWay #2");
      Set workerkey = workMap.keySet();
      Iterator it3 = workerkey.iterator();
      while (it3.hasNext()) {
         Object key = it3.next();
         Worker wrkr = (Worker) workMap.get(String.valueOf(key));
         System.out.println("Worker ID: " + key + " Name: " + wrkr.getName() + " Age: " + wrkr.getAge() + " Salary: "
            + wrkr.getSalary());
      }

      // Item #8.3
      System.out.println("\nWay #3");
      int id = 0;
      for (Worker wrkr : workers) {
         System.out.println("Worker ID: " + id + " Name: " + wrkr.getName() + " Age: " + wrkr.getAge() + " Salary: "
            + wrkr.getSalary());
         id++;
      }
   }

}
