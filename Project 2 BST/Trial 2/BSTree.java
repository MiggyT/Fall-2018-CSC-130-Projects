import java.util.*; 
public class BSTree {
   private BinaryNode root;
   
   //----------------------------------Constructor-------------------------------------------------------------------------//
   public BSTree (BinaryNode root) {
      this.root = root;
   }
   
   public BSTree() {
      root = null;
   }
   //---------------------------------Constructor--------------------------------------------------------------------------//
   
   public BinaryNode getRoot() {   // returns the root 
      return root;
   }
   
   public boolean isEmpty() { // checks if the BST is empty and returns True or False 
      return root == null;
   }
   
   //----------------------------------------------Contains method-------------------------------------------------------//
   public boolean contains(int value) {
      return contains(value,root);
   }
   
   private boolean contains(int value, BinaryNode node) {
      if(node == null) {
         return false;
      }
      int nData = node.getData();
      if (value == nData) {
         return true;
      }
      else if (value < nData) {
         return contains(value, node.getLeft());
      }  
      else {
         return contains(value, node.getRight());
      }
   }
   //----------------------------------------------Contains method------------------------------------------------------//
   
   //-----------------------------------------------Edge Casses---------------------------------------------------------//
   public void insert() {
      System.out.println("Oops you are inserting nothing into the BST, Please input a integer such as 1,2,3...");
   }
   public void insert(double data) {
      System.out.println("Oops you are trying to insert a double into the BST, Please input a integer such as 1,2,3...");
   }
   public void insert(String data) {
      System.out.println("Oops you are trying to insert a string into the BST, Please input a integer such as 1,2,3...");
   }
   public void insert(boolean data) {
      System.out.println("Oops you are trying to insert a boolean into the BST, Please input a integer such as 1,2,3...");
   }
   //----------------------------------------------Edge Casses---------------------------------------------------------//
   
   //---------------------------------------------------Insert Method----------------------------------------------------//
   public void insert(int value) { 
      root = insert(value,root);
   }
   
   private BinaryNode insert(int value, BinaryNode node) {
      if (node == null) {
         return new BinaryNode(value);
      }
      if (value < node.getData()) {
         node.setLeft(insert(value,node.getLeft()));
      }
      else if (value > node.getData()) {
         node.setRight(insert(value, node.getRight()));
      }
      return node;
   }
   //-------------------------------------------------Insert Method---------------------------------------------------------//
   
   //-------------------------------------------------In Order Traversal-----------------------------------------------------//
   public void inOrder() {
      inOrder(root);
   } 

   private void inOrder(BinaryNode node) {
      //Stack myStack = new Stack();
      Stack<BinaryNode> myStack = new Stack<BinaryNode>(); 
      BinaryNode current = node; //temporary node
      if (node == null) {
         return;
      }
      while(current != null || myStack.size() > 0) {
         while(current != null) {
            myStack.push(current);   
            current = current.getLeft(); 
         }
         current = myStack.pop();
         System.out.print(current.getData() + " ");
         current = current.getRight();         
      }     
   }
   
   public void inOrder(int[] a) { //These methods are for the sort integers class and are slightly diffrent from the ones above to deal with arrays 
      inOrder(root, a);
   }
   private int[] inOrder(BinaryNode node, int[] a) {
      Stack<BinaryNode> myStack = new Stack<BinaryNode>(); 
      BinaryNode current = node; //temporary node 
      int i = 0;
      
      while (!myStack.isEmpty() || current != null) {
         if(current != null) {
            myStack.push(current);
            current = current.getLeft();
         } else { 
            current = myStack.pop();
            a[i] = current.getData();
            i++;
            current = current.getRight();
         }
      }
      return a;
   }
   //--------------------------------------------------------------In Order Traversal --------------------------------------------------//
}