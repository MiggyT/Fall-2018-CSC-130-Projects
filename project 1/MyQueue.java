public class MyQueue {
   private MyStack stack1 = new MyStack();
   private MyStack stack2 = new MyStack(); // this stack basically is the queue as it will hold the elements in correct order
   //-----------------------------------Constructors-------------------------------------------------------------------------
   public MyQueue (String[] list) {
      for (int i = 0;i < list.length; i++) {
         stack1.push(list[i]);
      }
   }
   
   public MyQueue () {
   }
   //-----------------------------------Constructors-------------------------------------------------------------------------
   public void enqueue(String data) {
      stack1.push(data);
   }
   //----------------------------------------------------------edge Case START-----------------------------------------------------------------------------
   public void enqueue() {
      System.out.println("oops your trying to enqueue nothing, please enqueue a string values for example \"z\".");
   }
   public void enqueue(int data) {
      System.out.println("Oops your trying to enqueue a int value inside a queue. Please push a string value for example \"x\"");
   }
   public void enqueue(double data) {
      System.out.println("Oops your trying to enqueue a double value inside a queue. Please push a string value for example \"x\"");
   }
   public void enqueue(boolean data) {
      System.out.println("Oops your trying to enqueue a boolean value inside a queue. Please push a string value for example \"x\"");
   } 
   //-----------------------------------------------------------edge Case END------------------------------------------------------------------------------
   public void shift() {                 // This method moves the elements from stack 1 to stack 2 
      if (stack2.isEmpty()) { 
         while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
         }
      }
   }
   
   public void reset() {                // This method moves the elements from stack 2 back to stack 1
      if (stack1.isEmpty()) {
         while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
         }
      }
   }
   
   public String dequeue() {          // my dequeue moves all the elements from stack 1 to stack 2 then pops from stack 2 and fiannly moves the elements from stack 2 back to stack 1
      shift(); 
      stack2.pop();
      reset();
      return ""; 
   }
   public boolean isEmpty() {       // checks to see if both of my stacks are empty to ensure that the queue is empty 
      return (stack1.isEmpty() && stack2.isEmpty());
   }
   public void printQueue() {  // moves the elements from stack 1 to stack 2 to be able to print propely then prints and finanly moves the elemnts from stack 2 back to stack 1 
      shift();
      stack2.printStack();
      reset(); 
   }
   
}