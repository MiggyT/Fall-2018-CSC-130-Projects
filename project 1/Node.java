public class Node {
   public String data;
   public Node next;
   
   public Node(String data) {
      this.data = data;
   }
   
   public void displayNode() { // this method displays the contents of the node 
         System.out.println(data);
   }
}