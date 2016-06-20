import java.util.*;
public class Test {
	public static void main(String args[]) {
		List list = new ArrayList(); //Change to LinkedList or Vector here
		list.add("Hello");
		list.add("World");
		list.add(1, "Learn");
		list.add(1, "Java");
		printList(list);
	}

	public static void printList(List list) { 
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (Object o : list) {
			System.out.println(o);
		}
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
	}
}
