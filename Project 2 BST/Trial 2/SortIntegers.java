public class SortIntegers {
   public static void main (String[] args) {
      BSTree treeA = new BSTree();
      int[] numbers = {8,8,8,4,10,12,3,7,5};   // creates array 
      sortIntegerArray(numbers,treeA);         // passes array and tree into the method 
      
      
   }
   public static int[] sortIntegerArray(int[] a,BSTree treeA) {   //This method inserts the array into the binary search tree and prints out the contents of the array 
      for(int i = 0; i < a.length;i++) {
         treeA.insert(a[i]);
      }
      treeA.inOrder(a);
      for(int j = 0; j < a.length;j++) {  // prints the contents of the array 
         System.out.print(a[j] + " ");
      }
      return a;
   }
   
}