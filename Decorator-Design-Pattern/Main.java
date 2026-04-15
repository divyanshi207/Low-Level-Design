import java.util.*;


abstract class BasePizza{
  abstract int cost();
}

class MargeritaPizza extends BasePizza{
  public int cost(){
    return 100;
  }
}
class CheesePizza extends BasePizza{
  public int cost(){
    return 150;
  }
}

abstract class Toppings extends BasePizza{
  BasePizza bp;
  Toppings(BasePizza bp){
    this.bp=bp;
  }
}

class CheeseTopping extends Toppings{
  public CheeseTopping(BasePizza bp){
    super(bp);
  }
  public int cost(){
    return bp.cost()+50;
  }
}

class CornTopping extends Toppings{
  public CornTopping(BasePizza bp){
    super(bp);
  }
  public int cost(){
    return bp.cost()+50;
  }
}


class OnionTopping extends Toppings{
  public OnionTopping(BasePizza bp){
    super(bp);
  }
  public int cost(){
    return bp.cost()+20;
  }
}


class Main{
  public static void main(String args[]){
    BasePizza bp=new CheesePizza();
    bp=new CornTopping(bp);
    bp=new CheeseTopping(bp);
    bp=new OnionTopping(bp);
    
    System.out.println(bp.cost());
  }
  
}
