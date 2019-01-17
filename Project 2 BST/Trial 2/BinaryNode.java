public class BinaryNode {
   private BinaryNode left;
   private BinaryNode right;
   private int data;
   //--------------------------------Constructors-------------------------------------//
   public BinaryNode(int data) { 
      this(data, null, null); 
   }
   
   public BinaryNode(int data, BinaryNode left, BinaryNode right) {
      this.left = left;
      this.right = right; 
      this.data = data;
   }
   //-------------------------------Constructors------------------------------------// 
   //--------------------------------Getters----------------------------------------//
   public BinaryNode getLeft() {
      return this.left;
   }
   
   public BinaryNode getRight() {
      return this.right;
   }
   
   public int getData() {
      return this.data;
   }
   //--------------------------------Getters----------------------------------------//
   
   //--------------------------------Setters----------------------------------------//
   public void setLeft(BinaryNode node) {
      this.left = node;
   }
   
   public void setRight(BinaryNode node) {
      this.right = node;
   }
   //--------------------------------Setters----------------------------------------//
}