
public class Employee {
	  private String id;
	    private String firstName;
	    private String lastName;
	    private String mgrid;
	    private String salary;
	    
	    Employee(String id, String firstName, String lastName, String mgrid, String salary ){
	    	this.id = id;
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.mgrid = mgrid;
	    	this.salary = salary;
	    }
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMgrid() {
			return mgrid;
		}
		public void setMgrid(String mgrid) {
			this.mgrid = mgrid;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
	

}
