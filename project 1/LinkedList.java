public class LinkedList {
   private Node first = null;
   
   public void putFirst(String data) { // <== this method basically does the work for push as it creates a node and links it 
      Node a = new Node(data);
      a.next = first;
      first = a;      
   }
   
   public Node removeFirst() { // <== this method does the work for pop as it moves the contents of the cuurent node into a temp node and returns that node while essentially deleting the current node 
      Node temp = first;
      first = first.next;
      return temp;
   }
   
   public void displayList() { // prints the contents of each node by traversing the linked list until reaching null 
      Node curr = first;
      while (curr != null) {
         curr.displayNode();
         curr = curr.next;
      }     
   }
   
   public boolean isEmpty() { // check if the list is empty by checking if first is equal to null therefore proving that it is empty if true
      return (first == null);
   }
}