package homeworkW2D1;


public class Worker {
   private int age;
   private String name;
   private double salary;
   public Worker() { 
   }
   public Worker (String name, int age, double salary) {
      this.name = name;
      this.age = age;
      this.salary = salary;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public double getSalary() {
      return salary;
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      long temp;
      temp = Double.doubleToLongBits(salary);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
   }
   @Override
   public boolean equals(Object obj) {
      Worker other = (Worker) obj;
      if(name == other.getName() && age == other.getAge() && salary == other.salary)
         return true;
      else
         return false;
   }
   public void setSalary(double salary) {
      this.salary = salary;
   }
   public void work() {
      System.out.println(name + " is working");
   }
}

