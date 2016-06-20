import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class AppWorker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//For no.1
		System.out.println("Name" +"\t \t \t" +"Age" + "\t \t \t"+ "Salary" + "\t \t \t");
		
		List<Worker> emp  = new ArrayList<Worker>();
		emp.add(new Worker("Simon",20,10000));
		emp.add(new Worker("Jame",25,13000));
		emp.add(new Worker("Alex",22,12000));
		
		//For no.2
		emp.add(1, new Worker ("Steven", 24, 15000));
		emp.remove(3);
		
		//main output
		for (Worker employee : emp){
			System.out.println(employee.getName() + "\t \t \t" + employee.getAge() + "\t \t \t" + employee.getSalary());
			
		}
		
		System.out.println("\n"+"For item no. 2: Steven was added to the list");
		System.out.println("For item no. 3: Alex was removed from the list");
		
		//for no.5
		java.util.Iterator<Worker> itr = emp.iterator();
		while(itr.hasNext()){
			Worker w = (Worker) itr.next();
			w.work();
		}
		
		//for no. 7
		Collections.sort(emp);
		Collections.reverse(emp);
		System.out.println("For item no. 7");
		System.out.println("\n"+"Name" +"\t \t \t" +"Age" + "\t \t \t"+ "Salary" + "\t \t \t");
		for (Worker employee : emp){
		System.out.println(employee.getName() + "\t \t \t" + employee.getAge() + "\t \t \t" + employee.getSalary());
		}
		//create hashmap
		Map<String, Worker> workMap = new HashMap <String, Worker>();
		for(int i = 0; i<emp.size(); i ++){
			workMap.put(String.valueOf(i), emp.get(i));	
		}
		
		//display hashmap
		System.out.println("For item no. 8");
		for (int i = 0; i < workMap.size(); i++) {
			System.out.println("Worker Id: " + i + " Name: " + 
								workMap.get(String.valueOf(i)).getName() + 
								" Age: " + workMap.get(String.valueOf(i)).getAge() + " Salary: " + workMap.get(String.valueOf(i)).getSalary());
			
		}
		for (Map.Entry<String, Worker> entry : workMap.entrySet()) {
			System.out.println("Worker ID: " + entry.getKey() + " Name: " + entry.getValue().getName() 
								+ " Age: " + entry.getValue().getAge() + " Salary: " + entry.getValue().getSalary());
			

		}
			
		java.util.Iterator<Entry<String, Worker>> itor = workMap.entrySet().iterator();
		while (itor.hasNext()){
			Entry<String, Worker> work = itor.next();
			System.out.println("Worker ID: " + work.getKey() + " Name: " + work.getValue().getName() + 
							" Age: " + work.getValue().getAge() + " Salary: " + work.getValue().getSalary());
			
		}
	}

}
