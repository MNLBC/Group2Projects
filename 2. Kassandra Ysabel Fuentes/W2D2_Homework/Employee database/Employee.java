package homework;

public class Employee {
    private String Id;
    private String firstName;
    private String lastName;
    private String mgrId;
    private String salary;
    private static int i = 0;

    Employee(String firstName, String lastName, String mgrId, String salary) {
       this.Id = null; //default
       this.firstName = firstName;
       this.lastName = lastName;
       this.mgrId = mgrId;
       this.salary = salary;
   }

    Employee(String Id,String firstName, String lastName, String mgrId, String salary) {
        this.Id = null; //default
        this.firstName = firstName;
        this.lastName = lastName;
        this.mgrId = mgrId;
        this.salary = salary;
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }
    
    public String getLastName() {
       return lastName;
   }

   public void setLastName(String LastName) {
       this.lastName =LastName;
   }

    public String getMgrId() {
        return mgrId;
    }

    public void setMgrId(String id) {
        this.mgrId = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary= salary;
    }
}