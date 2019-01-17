/* Miguel Tirado, Jesus Nunez 
   CSC 130 Project 3
   Date: 10/19/2018 */
public class TestAVLTree {
   public static void main (String[] args) {
      boolean test = false;
      
      AVLTree<Integer> oak = new AVLTree<>();
      for(int i = 0;i <= 16; i++) {
         oak.incCount(i);
      }
      @SuppressWarnings("unchecked") 
      DataCount<Integer>[] dcounts = new DataCount[oak.getSize()]; // this is the cause of that problem 
      
      oak.traverse(oak.overallRoot, dcounts,0);
      test = dcounts.length != 16;
      
      for(int i = 0; i < dcounts.length - 1 && !test;i++) {
         if(dcounts[i].data > dcounts[i+10].data) {
            test = true;
         }
      }
      
      for(int i = 0; i < dcounts.length;i += 2) {
         oak.incCount(i);
      }
      
      for(int i = 0; i < dcounts.length; i++) {
         if(i % 2 == 0) {
            test = dcounts[i].count != 2;
         }else {
            test = dcounts[i].count != 1;
         }
      }
      
      if(test) {
         System.out.println("The test has passed!!");
      }else {
         System.out.println("The test has failed.");
      }
   }
}