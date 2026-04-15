import java.util.*;


abstract class Handler{
  public static int INFO=1;
  public static int DEBUG=2;
  public static int ERROR=3;
  
  protected Handler next;
  Handler(Handler next){
    this.next=next;
  }
  public void handleRequest(String message,int level){
    if(next!=null){
      next.handleRequest(message, level);
    }
  }
}

 class InfoLogger extends Handler{
  InfoLogger(Handler h){
    super(h);
  }
  public void handleRequest(String message,int level){
    if(level== INFO)
      System.out.println("INFO "+message);
    else
      super.handleRequest(message,level);
  }
}
 class DebugLogger extends Handler{
  DebugLogger(Handler h){
    super(h);
  }
  public void handleRequest(String message,int level){
    if(level== DEBUG)
      System.out.println("DEBUG "+message);
    else
      super.handleRequest(message,level);
  }
}

 class ErrorLogger extends Handler{
  ErrorLogger(Handler h){
    super(h);
  }
  public void handleRequest(String message,int level){
    if(level== ERROR)
      System.out.println("ERROR "+message);
    else
      super.handleRequest(message,level);
  }
}

class Main {
  public static void main(String args[]) {

  Handler handler=new InfoLogger(new DebugLogger(new ErrorLogger(null)));
  handler.handleRequest("some debug",Handler.DEBUG);
  handler.handleRequest("some error", Handler.ERROR);
  handler.handleRequest("some info",Handler.INFO);
   
  }
}
