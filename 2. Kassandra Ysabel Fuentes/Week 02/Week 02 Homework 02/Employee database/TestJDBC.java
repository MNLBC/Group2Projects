package homework;

public class TestJDBC {
	
	public static void main(String args[]) {
	    JDBCOperation.getAll();
	    
//	    JDBCOperation.insert(new Student("Achilles", "Male", "14"));
	    JDBCOperation.insert(new Employee("1", "rose", "Tyler", "4", "1500"));
	    JDBCOperation.insert(new Employee("2", "Matha", "Jones", "4","2200"));
	    JDBCOperation.insert(new Employee("3", "Donna", "Noble", "4", "1300"));
	    JDBCOperation.insert(new Employee("4", "Doctor", "Who", "","5500"));
	    JDBCOperation.insert(new Employee("5", "Jack", "Harkness", "1", "3500"));
	    JDBCOperation.insert(new Employee("6", "Alex", "Lee", "1", "4500"));
	    JDBCOperation.getAll();
	    
////	    JDBCOperation.update(new Student("Bean", "Male", "7"));
	    JDBCOperation.update("Tate", "Jones");
	    JDBCOperation.getAll();
	}
	

}
