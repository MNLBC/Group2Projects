import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Worker implements Comparable {
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
		// 1. To create a List and add three workers, and their information
		// shown like this:
		System.out.println("1. Create List with 3 worker");
		Worker workerSimon = new Worker();
		Worker workerJame = new Worker();
		Worker workerAlex = new Worker();

		workerSimon.setName("Simon");
		workerSimon.setAge(20);
		workerSimon.setSalary(10000);

		workerJame.setName("Jame");
		workerJame.setAge(25);
		workerJame.setSalary(13000);

		workerAlex.setName("Alex");
		workerAlex.setAge(22);
		workerAlex.setSalary(12000);

		List<Worker> workerList = new ArrayList<Worker>();
		workerList.add(workerSimon);
		workerList.add(workerAlex);
		workerList.add(workerJame);
		System.out.println("List in 1:");
		System.out.println("Name | Age | Salary");

		for (Worker worker : workerList) {
			System.out.println(worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary());
		}
		System.out.println();
		// 2. Add one worker before Jame ( Steven, 24, 15000)
		System.out.println("2. Add one worker before Jame (Steven, 24, 15000)");
		Worker workerSteven = new Worker();
		workerSteven.setName("Steven");
		workerSteven.setAge(24);
		workerSteven.setSalary(15000);

		workerList.add(workerList.indexOf(workerJame), workerSteven);
		System.out.println("List in 2:");
		System.out.println("Name | Age | Salary");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary());
		}
		System.out.println();

		// 3. Remove the worker Alex’s information
		System.out.println("3. Remove the worker Alex’s information");
		workerList.remove(workerAlex);
		System.out.println("List in 3:");
		System.out.println("Name | Age | Salary");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary());
		}
		System.out.println();

		// 4. Go through the list using for statement and print out all the
		// worker’s information.
		System.out.println("4. Go through the list using for statement and print out all the worker’s information.");
		System.out.println("List in 4:");
		System.out.println("Name | Age | Salary");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary());
		}
		System.out.println();

		// 5. Go through the list using Iterator statement to call all the
		// worker’s method work.
		System.out.println("5. Go through the list using Iterator statement to call all the worker’s method work.");

		Iterator workIterator = workerList.iterator();

		while (workIterator.hasNext()) {
			Worker worker = (Worker) workIterator.next();
			worker.work();
		}
		System.out.println();
		// 6. Over write the equals method for the class Worker. New equals
		// method return true only if the workers’ name, age and salary are the
		// same at the same time.

		System.out.println(
				"6. Over write the equals method for the class Worker. New equals method return true only if the workers’ name, age and salary are the same at the same time.");
		
		Worker workerSimonDummy = new Worker();
		workerSimonDummy.setName("SimonDummy");
		workerSimonDummy.setAge(21);
		workerSimonDummy.setSalary(10000);
		
			System.out.println("Simon Vs. Simon");
			System.out.println(workerSimon.equals(workerSimon));
			System.out.println("Simon Vs. SimonDummy");
			System.out.println(workerSimon.equals(workerSimonDummy));
		
		// 7. Sort the all the workers from high to low by salary and print out
		// the all the workers information with the format “Name: “ + name + “
		// Salary: “ + salary.
		System.out.println(
				"7. Sort the all the workers from high to low by salary and print out the all the workers information with the format “Name: “ + name + “  Salary: “ + salary.");
	
		Collections.sort(workerList, Collections.reverseOrder());
		System.out.println("List in 7:");
		System.out.println("Name | Salary");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + " | " + worker.getSalary());
		}
		System.out.println();
		// 8. Add a id to Worker class, and save the above data to workMap.
		// Map<String, Worker > ( Worker ID, Worker) . At least three ways to go
		// through the workMap, to print out all the workder’s information with
		// Worker id and all other information like “Worker Id: “ + “Name: “ +
		// name + “Age: “ + age + “ Salary: “ + salary.
		System.out.println(
				"8. Add a id to Worker class, and save the above data to workMap. Map<String, Worker > ( Worker ID, Worker) . At least three ways to go through the workMap, to print out all the workder’s information with Worker id and all other information like “Worker Id: “ + “Name: “ + name + “Age: “ + age + “ Salary: “ + salary");
		HashMap<String, Worker> workMap = new HashMap<String, Worker>();
		
		for(int i = 0; i< workerList.size(); i++){
			workMap.put(String.valueOf(i), workerList.get(i));
		}
		
		printWorkerList(workMap);
		
		
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
		if (age == other.age && name == other.name && salary == other.salary){
			return true;
		}

		return false;
	}

	@Override
	public int compareTo(Object object) {
		// TODO Auto-generated method stub
		 Worker other = (Worker) object;
		 Double objSalary = this.salary;
		   int salary_comparison = objSalary.compareTo(other.salary);

		return salary_comparison;
	
	}
	
	public static void printWorkerList(HashMap<String, Worker> hash) { 

		
		Set workSet = hash.entrySet();
		
		Iterator hashIterator = workSet.iterator();
		
		System.out.println("Way 1");
		System.out.println("Id | Name | Age | Salary");
	      while(hashIterator.hasNext()) {
	         Map.Entry me = (Map.Entry)hashIterator.next();
	         
	         Worker worker = new Worker();
	         worker = (Worker) me.getValue();
			System.out.println(
					me.getKey() + " | " + worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary());
	        
	      }
	      System.out.println();
	  	System.out.println("Way 2");
	      System.out.println("Id | Name | Age | Salary");
	      
	      for(Map.Entry<String, Worker> entry  : hash.entrySet()){
	    	  Worker worker = new Worker();
	    	  worker = entry.getValue();
	    	  
	    	  System.out.println(entry.getKey()  + " | " + worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary() );
	      }
	      System.out.println();
	     
	  	System.out.println("Way 3"); 
	      System.out.println("Id | Name | Age | Salary");
	      for (String key : hash.keySet()) {
	    	  Worker worker = new Worker();
	    	  worker = hash.get(key);
	    	  System.out.println(key + " | " + worker.getName() + " | " + worker.getAge() + " | " + worker.getSalary() );
	    	}

	    	

	}
		
}

