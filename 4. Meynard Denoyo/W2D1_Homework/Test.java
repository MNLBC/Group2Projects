package w2d1hw;


import java.util.*;
public class Test {
   public static void main(String args[]) {
      List list = new ArrayList();        //Declaring an Arraylist
//      List list = new LinkedList();     //Declaring an LinkedList for number 2.3
//      List list = new Vector();         //Declaring an Vector for number 2.4
      list.add("Hello");   
      list.add("World");
      list.add(1, "Learn");
      list.add(1, "Java");
      printList(list);
   }

   public static void printList(List list) { 
// 1
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
