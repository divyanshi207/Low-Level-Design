import java.util.*;


interface Employee{
  void createEmployee(String role);
  void deleteEmployee(String role);
}

class EmployeeDAO implements Employee{
  public void createEmployee(String role){
    System.out.println("created empooyee");
  }
  public void deleteEmployee(String role){
    System.out.println("dleted empooyee");
  }
}
class Proxy implements Employee{
  Employee employee;
  Proxy(){
    this.employee=new EmployeeDAO();
  }
  public void createEmployee(String role) {
    if(role=="ADMIN")
      employee.createEmployee(role);
    else
      throw new RuntimeException("Access denied admin only can create ");
  }
  public void deleteEmployee(String role){
    if(role=="USER")
      employee.deleteEmployee(role);
    else
      throw new RuntimeException("Access denied user only can delete ");
  }
  
}

class Main {
  public static void main(String args[]) {
    
    Employee e=new Proxy();
    e.deleteEmployee("ADMIN");
  
  }
}
