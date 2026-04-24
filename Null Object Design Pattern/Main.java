import java.util.*;

interface Vehicle{
   int getSeatCapacity();
   int getTankCapacity();
}

class Car implements Vehicle{
  public int getSeatCapacity(){
    return 10;
  }
  public int getTankCapacity(){
    return 20;
  }
}

class nullVehicle implements Vehicle{
  public int getSeatCapacity(){
    return 0;
  }
  public int getTankCapacity(){
    return 0;
  }
}

class VehicleFactory{
  static public Vehicle getVehicle(String v){
    if(v=="Car")
      return new Car();
    else
      return new nullVehicle();
  }
}

public class Main {
    public static void main(String[] args) {
      Vehicle v1=VehicleFactory.getVehicle("Bike");
      System.out.println(v1.getSeatCapacity());
    }
}
