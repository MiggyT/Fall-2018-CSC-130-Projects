public class MyTestBeta {
   public static void main(String[] args) {
    MyStack st = new MyStack();
    MyQueue sd = new MyQueue();
    String[] array = {"x","y","z"};
    MyStack sp = new MyStack(array);
    //sp.printStack();
    
    //System.out.println(sd.isEmpty());
    st.push(true);
    sd.enqueue(2);
    sd.enqueue(3.0);
    sd.enqueue("c");
    sd.dequeue();
    //sd.dequeue();
    sd.enqueue("1");
    sd.enqueue("2");

    sd.printQueue();

    /*
    sd.enqueue("1");
    sd.enqueue("2");
    sd.printQueue();
    System.out.println("/////////////////////");
    sd.enqueue("x");
    sd.enqueue("y");
    sd.printQueue(); */ 
    /*
    System.out.println("/////////////////////");
    sd.enqueue("9");
    sd.enqueue("10");
    sd.dequeue();
    sd.printQueue(); */   

   }
}