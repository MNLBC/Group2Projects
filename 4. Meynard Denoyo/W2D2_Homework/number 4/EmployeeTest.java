package w2d2hw;


public class EmployeeTest {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      JDBCconn.insert( new Employee("rose", "Tyler", "4", "1500"));
      JDBCconn.insert( new Employee("Matha", "Jones", "4", "2200"));
      JDBCconn.insert( new Employee("Donna", "Noble", "4", "1300"));
      JDBCconn.insert( new Employee("Doctor", "Who", "", "5500"));
      JDBCconn.insert( new Employee("Jack", "Harkness", "1", "3500"));
      JDBCconn.getAll();
      
      JDBCconn.insert(new Employee("Alex", "Lee", "1", "4500"));
      JDBCconn.getAll();
      
      JDBCconn.modify("last_name", "Jones", "last_name", "Tate");
      JDBCconn.getAll();
   }

}
