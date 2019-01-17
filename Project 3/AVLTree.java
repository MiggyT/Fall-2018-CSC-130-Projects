/* Miguel Tirado, Jesus Nunez 
/* CSC 130 Project 3
/*  10/19/2019                */
public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {
   //----------------------calling method from parent class and overiding------------------//
   @Override //Overide used to check if im actually overiding a method 
   public void incCount(E data) {
      super.incCount(data);
      overallRoot = balance(overallRoot);
   }
   //---------------------------call balance method --------------------------------------//
   //--------------------------Creating hieght field and constructor-----------------------------------//
   private int height;
   
   public int height() {
      return height;
   }
   // This method keeps track of the height on the BST tree by creating 2 int varai
   public int height(BSTNode node) {
      int right, left;
      if (node == null) {  // if root is null than the height is zero.
         return 0;
      }else  {
         left = height(node.left);
         right = height(node.right);
         if(right > left) {
            return right+1;
         }else {
            return left+1;
         }
      }
   }
   //-------------------------------------- End of height ------------------------------------------------//
   //---------------------------------------balance method------------------------------------------------//
   public BSTNode balance (BSTNode node) { // This method determines which cases to use and runs it.
      if (height(node.left) - height(node.right) > 1) {            
         if(height(node.left.left) >= height(node.left.right)) {      
            node = singleRightRotation(node);                         // Case 1          
         }     
         else {
            node = doubleLeftRightRotation(node);                    // Case 2
          }
      }else if (height(node.right) - height(node.left) > 1) {
         if (height(node.right.right) >= height(node.right.left)) {
            node = singleLeftRotation(node);                         // Case 4
         }
         else {
            node = doubleRightLeftRotation(node);                    // Case 3
         }
      }          
      return node; 
   }
   //-----------------------------------------end of balance------------------------------------------------//
   //-----------------------------------------4 balance cases-----------------------------------------------//
   private BSTNode singleRightRotation (BSTNode k2) { //Case 1
      BSTNode k1 = k2.left;
      k2.left = k1.right;
      k1.right = k2;
      return k1;
   }
   
   private BSTNode singleLeftRotation (BSTNode k1) { // Case 4 
      BSTNode k2 = k1.right;
      k1.right = k2.left;
      k2.left = k1;
      return k2;
   }
   
   private BSTNode doubleLeftRightRotation (BSTNode k3) { // Case 2
      k3.left = singleLeftRotation(k3.left);
      return singleRightRotation(k3);
   }
   
   private BSTNode doubleRightLeftRotation (BSTNode k1) { //Case 3
      k1.right = singleRightRotation(k1.right);
      return singleLeftRotation(k1);
   }
   //----------------------------------------end of balance cases------------------------------------------//
}
   