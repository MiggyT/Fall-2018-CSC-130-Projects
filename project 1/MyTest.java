public class MyTest {
   public static void main(String[] args) {
      MyStack stackA = new MyStack();
      MyQueue queueA = new MyQueue();
      String[] testA = {"x","y","z"};         // NOTE this array is used to test MyStack(String[] list) and MyQueue(String[] list) constructor methods in my java files 
      MyStack stackC = new MyStack(testA);
      MyQueue queueC = new MyQueue(testA);
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //--------------------------------------------------------------------Testing MyStack methods START------------------------------------------------------------------//
      System.out.println("------------------------------------------------------------------Testing MyStack START--------------------------------------------------------");
      testPush(stackA);
      stackA.printStack();
      System.out.println("The tests have passed!");
      System.out.println("");
      
      testPop(stackA);
      stackA.printStack();
      System.out.println("The test has passed!");
      System.out.println("");
      
      testEmptyS(stackA);
      System.out.println("The test has passed!");
      System.out.println("");

      testConstructorA(); 
      stackC.printStack();
      System.out.println("The test has passed!");
      System.out.println("");
      
      testEdgeCaseA(stackA);
      System.out.println("The edge cases were dealt with!");
      System.out.println(""); 
      System.out.println("------------------------------------------------------------------Testing MyStack END----------------------------------------------------------");    
      //--------------------------------------------------------------------Testing MyStack methods END------------------------------------------------------------------//
      //--------------------------------------------------------------------Testing MyQueue methods START----------------------------------------------------------------//
      System.out.println("------------------------------------------------------------------Testing MyQueue START--------------------------------------------------------");
      testQueue(queueA);
      queueA.printQueue();
      System.out.println("The tests have passed!");
      System.out.println();
      
      testDequeue(queueA);
      queueA.printQueue();
      System.out.println("The test has passed!");
      System.out.println();
      
      testEmptyQ(queueA);
      queueA.printQueue();
      System.out.println("The test has passed!");
      System.out.println();
      
      testConstructorB();
      queueC.printQueue();
      System.out.println("The test has passed!");
      System.out.println("");
      
      testEdgeCaseB(queueA);
      queueA.printQueue();
      System.out.println();
      System.out.println("The edge cases were dealt with!");
      System.out.println(""); 
      System.out.println("------------------------------------------------------------------Testing MyQueue END--------------------------------------------------------"); 
      //--------------------------------------------------------------------Testing MyQueue methods END----------------------------------------------------------------//

   }
   public static void testPush(MyStack A) {
      System.out.println("Here i am testing to see if i can push elements to my stack and print them out properly.");
      A.push("a");
      A.push("b");
      A.push("c");
      System.out.println("The values that im expecting are \"c\" on top, \"b\" in the middle, and \"a\" on the bottom.");
   }
   public static void testPop(MyStack A) {
      System.out.println("Here i am testing to see if i can pop an element out of my stack.");
      A.pop();
      System.out.println("The values that im expecting are \"b\" on top and \"a\" on the bottom.");
   }
   public static void testEmptyS(MyStack A) {
      System.out.println("Here i am testing tesing to see if my stack is empty by printing true if empty and false if not empty.");
      System.out.println("Im expecting MyStack to print false becuase i have prevously pushed \"b\" and \"a\" into it.");
      System.out.println(A.isEmpty());
      System.out.println();
      System.out.println("Now lets test if it can print true if we pop the two remain elements");
      A.pop();
      A.pop();
      System.out.println("The new output should be True.");
      System.out.println(A.isEmpty());
      System.out.println();
   }
   public static void testConstructorA() {
      System.out.println("Here i am testing to see if the user can manually enter a string array and have Mystack create and print it.");
      System.out.println("Please note that the string array was already created ahead of time and contains {\"x\",\"y\",\"Z\"}");
      System.out.println("Im expecting MyStack to print \"z\" on top, \"y\" in the middle, and \"x\" on the bottom");
  }
  public static void testEdgeCaseA(MyStack A) {
       System.out.println("Here i am going to test a couple edge cases meant to try to break my program.");
       System.out.println("I am going to first try to push nothing into MyStack.");
       System.out.println();
       A.push();
       System.out.println("As you can see i have returned a message to the user to please enter a value when pushing.");
       System.out.println();
       System.out.println("The next case is to try pop an element when there are none left onto the stack.");
       System.out.println("For clarifaction we are going to use the stack we have been usign since the begining which has 0 elements inside currently.");
       System.out.println("I am expecting MyStack to display null or nothing since thats how i have set it up.");
       A.pop();
       A.pop();
       System.out.println();
       System.out.println("There is nothing being displayed therefore trying to pop elements from the an empty stack will not crash the program.");      
  }
  public static void testQueue(MyQueue A) {
      System.out.println("Here i am testing to see if i can queue elements into MyQueue and print them out properly.");
      System.out.println("Please note that this queue can be thot as vertical to which elements are enqueued from the bottom and dequeue from the top");
      A.enqueue("a");
      A.enqueue("b");
      A.enqueue("c");
      System.out.println("The values that im expecting are \"a\" on top, \"b\" in the middle, and \"c\" on the bottom.");          
  }
  public static void testDequeue(MyQueue A) {
      System.out.println("Here i am testing to see if i can dequeue an element out of my queue.");
      A.dequeue();
      System.out.println("The values that im expecting are \"b\" on top and \"c\" on the bottom.");
  }
  public static void testEmptyQ(MyQueue A) {
      System.out.println("Here i am testing tesing to see if my queue is empty by printing true if empty and false if not empty.");
      System.out.println("Im expecting MyQueue to print false becuase i have prevously enqueued \"b\" and \"c\" into it.");
      System.out.println(A.isEmpty());
      System.out.println();
      System.out.println("Now lets test if it can print true if we dequeue the two remain elements");
      A.dequeue();
      A.dequeue();
      System.out.println("The new output should be True.");
      System.out.println(A.isEmpty());
      System.out.println();
  }
  public static void testConstructorB() {
      System.out.println("Here i am testing to see if the user can manually enter a string array and have MyQueue create and print it.");
      System.out.println("Please note that the string array was already created ahead of time and contains {\"x\",\"y\",\"Z\"}");
      System.out.println("Im expecting MyStack to print \"x\" on top, \"y\" in the middle, and \"z\" on the bottom");
  }
  
  public static void testEdgeCaseB(MyQueue A) {
       System.out.println("Here i am going to test a couple edge cases meant to try to break my program.");
       System.out.println("I am going to first try to enqueue nothing into MyQueue.");
       System.out.println();
       A.enqueue();
       System.out.println("As you can see i have returned a message to the user to please enter a string value when pushing.");
       System.out.println();
       System.out.println("The next case is to try dequeue an element when there are none left onto the stack.");
       System.out.println("For clarifaction we are going to use the queue we have been using since the begining which has 0 elements inside currently.");
       System.out.println("I am expecting MyQueue to display null or nothing since thats how i have set it up.");
       A.dequeue();
       A.dequeue();
       System.out.println();
       System.out.println("There is nothing being displayed therefore trying to dequeue elements from the an empty queue will not crash the program."); 
       System.out.println("for my final test i am goin to try to enqueue mutliple elements into my queue then dequeue two elements and finanly print the queue.");
       System.out.println("I am trying to check if myQueue will print the proper output by enqueing numbers 1-10 as string,");  
       A.enqueue("1");
       A.enqueue("2");
       A.enqueue("3");
       A.enqueue("4");
       A.enqueue("5");
       A.enqueue("6"); 
       A.enqueue("7");
       A.enqueue("8");
       A.enqueue("9");    
       A.enqueue("10"); 
       A.dequeue();
       A.dequeue();
       System.out.println("I am expecting my queue to print as follows 3-10 from top to bottom, 3 being on top and 10 being on the bottom.");
       System.out.println();
  }        
}