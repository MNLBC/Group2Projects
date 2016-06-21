package W02M09;

import java.util.*;

public class TestLinkedList {

   public static void main(String args[]) {
      List list = new LinkedList();
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
