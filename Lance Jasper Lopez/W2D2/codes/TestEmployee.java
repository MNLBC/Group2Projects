import java.sql.SQLException;

class TestEmployee {
	public static void main(String[] args) throws SQLException {
		
		Employee expendableEmployee =new Employee("2", "Matha", "Jones", "4", "2200");
		EmployeeRecOperation.create_table();
		EmployeeRecOperation.insert(new Employee("1", "Rose", "Tyler", "4", "1500" ));
		EmployeeRecOperation.insert(expendableEmployee);
		EmployeeRecOperation.insert(new Employee("3", "Donna", "Noble", "4", "1300" ));
		EmployeeRecOperation.insert(new Employee("4", "Doctor", "Who", "", "1500" ));
		EmployeeRecOperation.insert(new Employee("5", "Jack", "Tyler", "1", "1500" ));
		//1)	Create a table, and insert a record to the table, and print out all the data in the table (6	Alex 	 Lee   1   4500)
		System.out.println("1)Create a table, and insert a record to the table, and print out all the data in the table (6	Alex 	 Lee   1   4500)");
		EmployeeRecOperation.insert(new Employee("6", "Alex", "Lee", "1", "4500" ));
		
		EmployeeRecOperation.getAll();
		
		System.out.println("2)Modify the last_name to “Tate” whose last name is “Jones”, and save it to database. And print out all the data in the table.");
		//2)	Modify the last_name to “Tate” whose last name is “Jones”, and save it to database. And print out all the data in the table.
		EmployeeRecOperation.updateLastName(expendableEmployee, "Tate");
		EmployeeRecOperation.getAll();
	}
}
