public class MyStack {
   LinkedList b = new LinkedList();
   //--------------------------------------------------Constructor--------------------------------------------------------------------
   public MyStack(String[] list) {
      for (int i = 0;i < list.length; i++) {
         b.putFirst(list[i]);
      }     
   }
   
   public MyStack() {
   } 
   //--------------------------------------------------Constructor--------------------------------------------------------------------
   public void push(String data) { // this mehtod basically pushes the data into the stack or linked list by calling putFirst() and passing the string varaible 
      b.putFirst(data);
   }
   public void push() {    // ------------------------------------------edge case prevention--------------------------------------------------------------------------------------- 
      System.out.println("Oops your trying to push nothing inside a stack. Please push a string value for example \"x\"");
   }
   public void push(int data) {
      System.out.println("Oops your trying to push a int value inside a stack. Please push a string value for example \"x\"");
   }
   public void push(double data) {
      System.out.println("Oops your trying to push a double value inside a stack. Please push a string value for example \"x\"");
   }
   public void push (boolean data) {
      System.out.println("Oops your trying to push a boolean value inside a stack. Please push a string value for example \"x\"");
   } 
   //--------------------------------------------------------------------edge case END ----------------------------------------------------------------------------------------------
   public String pop(){   // this method pops the elemnts from the stack or removes them from the linked list while returning the content of the elemtns or returning null if stack is empty 
      Node temp = null;
   
      if(!b.isEmpty()) {  
         temp = b.removeFirst();
         return temp.data;
      }
      return null;
   }
   
   public void printStack() { // prints the elements from the stack by calling display list from linked list 
      b.displayList();
   }
   
   public boolean isEmpty() {  // returns true if the stack is empty by calling the isEmpty() method from linked lsit and return false if stack is not empty 
      return (b.isEmpty());
   }
   
   
}