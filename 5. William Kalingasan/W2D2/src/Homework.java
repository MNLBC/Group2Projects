import java.sql.ResultSet;
import java.sql.SQLException;

public class Homework {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      DBConnection dbConnect = new DBConnection();
      
      // refresh data
      // 1) Create a table, and insert a record to the table, and print out all the data in the table
      String[] empDetails = {"6","Alex","Lee","1","4500"};
      dbConnect.insert(empDetails);
      System.out.println("ITEM 1");
      display();
      
      // 2) Modify the last_name to “Tate” whose last name is "Jones, and save it to database. And print out all the data in the table.
      dbConnect.updateLastName("Jones", "Tate");
      System.out.println("\nITEM 2");
      display();
      
      dbConnect.deleteAll();
      
   }
   
   public static void display(){
      DBConnection dbConnect = new DBConnection();
      try {
         ResultSet rs = dbConnect.showAll();
         System.out.println("ID\t\tFIRST NAME\t\tLAST NAME\t\tMGRID\t\tSALARY");
         while(rs.next()){
            System.out.println(rs.getString("ID") + "\t\t\t" + rs.getString("FIRST_NAME") + "\t\t\t" + 
         rs.getString("LAST_NAME") + "\t\t\t" + rs.getString("MGRID") + "\t\t\t" + rs.getString("SALARY"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
