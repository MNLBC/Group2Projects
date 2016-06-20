package W02M09;

import java.util.*;

import banking.domain.Customer;

public class WorkerInformation
{

   @SuppressWarnings("rawtypes")
   public static void main(String args[]) 
   {
      List<Worker> listOfWorkers = new ArrayList<Worker>();
      Worker listInfo = new Worker();

      listOfWorkers.add(0, new Worker("Simon", 20, 10000));
      listOfWorkers.add(1, new Worker("Jame", 25, 13000));
      listOfWorkers.add(2, new Worker("Alex", 22, 12000));
      
      // Print all 3 worker
      Iterator iterateWorker = listOfWorkers.listIterator();
      System.out.println("Name          " + "Age          " + "Salary");
      while (iterateWorker.hasNext()) 
      {
         Worker wrkr = (Worker) iterateWorker.next();
         System.out.println(wrkr.getName() + "            " + wrkr.getAge() + "          " + wrkr.getSalary());
      }

      // Edit worker
      int indexJame = 0;
      int indexAlex = 0;
      for (int j = 0; j < listOfWorkers.size(); j++)
      {
         if (listOfWorkers.get(j).getName().equals("Jame")) 
         {
            indexJame = j;
         }
      }
      listOfWorkers.add(indexJame, new Worker("Steven", 24, 15000));

      for (int k = 0; k < listOfWorkers.size(); k++) 
      {
         if (listOfWorkers.get(k).getName().equals("Alex")) 
         {
            indexAlex = k;
         }
      }
      listOfWorkers.remove(indexAlex);

      // Print using for loop
      System.out.println();
      System.out.println("Name          " + "Age          " + "Salary");
      for (Worker listAll : listOfWorkers) 
      {
         System.out.println(listAll.getName() + "            " + listAll.getAge() + "          " + listAll.getSalary());
      }

      // method work()
      System.out.println();
      Iterator iterate = listOfWorkers.listIterator();
      while (iterate.hasNext()) 
      {
         Worker wrkr = (Worker) iterate.next();
         wrkr.work();
      }
      
      // item# 6 test
      System.out.println();
      System.out.println("item# 6 test");
      System.out.println((new Worker("Kass",1,1)).equals(new Worker("Ysabel",1,1)));
      
      // do sorting
      Collections.sort(listOfWorkers);
      Collections.reverse(listOfWorkers );
      System.out.println();
      System.out.println("Name          " + "Age          " + "Salary");
      for (Worker listAll : listOfWorkers) 
      {
         System.out.println(listAll.getName() + "            " + listAll.getAge() + "          " + listAll.getSalary());
      }
      
      
      // HashMap
      Map<String, Worker> workMap = new HashMap<String, Worker>();
      for (int l=0; l < listOfWorkers.size(); l++)
      {
         workMap.put(String.valueOf(l), listOfWorkers.get(l));
      }
      
      System.out.println();
      for (int i = 0; i < workMap.size(); i++) {
         System.out.println("Worker ID:  " + "Name:  " + workMap.get(String.valueOf(i)).getName() 
         + "  Age:  " + workMap.get(String.valueOf(i)).getAge() + "   Salary: " + workMap.get(String.valueOf(i)).getSalary());
      }
      
      System.out.println();
      for (Map.Entry<String, Worker>  o : workMap.entrySet()) {
         System.out.println("Worker ID:  " + o.getKey() + "  Name: " + o.getValue().getName() 
         + "  Age: " + o.getValue().getAge() + "   Salary: " + o.getValue().getSalary());  
      }
        
      System.out.println();
      Set workSet = workMap.entrySet(); 
      Iterator hashIterator = workSet.iterator();
      while(hashIterator.hasNext()) {
               Map.Entry me = (Map.Entry)hashIterator.next();
               
               Worker worker = new Worker();
               worker = (Worker) me.getValue();
      System.out.println("Worker ID:  " + me.getKey() + "  Name: " + 
               worker.getName() + " Age:  " + worker.getAge() + " Salary:  " + worker.getSalary());

      }
   }
}
