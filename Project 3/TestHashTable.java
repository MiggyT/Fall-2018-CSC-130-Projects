/* Miguel Tirado, Jesus Nunez 
 * CSC 130, Project 3 
 * Date: 10/24/2018  */
public class TestHashTable {
   public static void main (String[] args) {
      HashTable table = new HashTable(10); // this number does somthing ? 
      //
      //--------------------------------------------issue start ------------------------------------------------//
      String [] sample = {"tirado","nunez","java","tirado","engineer","tirado","csc 130",
                        "nunez", "jump man", "hamlet", "engineer", "java", "nunez", "csc 130"};
                        
      DataCount<String> d0 = new DataCount<>("nunez",3);
      DataCount<String> d1 = new DataCount<>("java",2);     
      DataCount<String> d2 = new DataCount<>("hamlet",1);
      DataCount<String> d3 = new DataCount<>("engineer",2);
      DataCount<String> d4 = new DataCount<>("csc 130",2);     
      DataCount<String> d5 = new DataCount<>("tirado",3);
      DataCount<String> d6 = new DataCount<>("jump man",1);
      
      DataCount[] storage = {d0,d1,d2,d3,d4,d5,d6}; 
      //-------------------------------------------issue ends --------------------------------------------------//      
      boolean test = false; 
      
      for(String s: sample) {
         table.incCount(s);
      }
      
      DataCount<String>[] dcount = table.getCounts();
      if(dcount.length != storage.length) {
         test = true;
      }else {
         int j = 0;
         for(DataCount<String> c : dcount) {
            if(!c.data.equals(storage[j].data) || c.count != storage[j].count) {
               test = true;
               break;
            }
            j++;
         }
      }
      
      if(test) {
         System.out.println("Test failed");
      } else {
         System.out.println("Test passed");
      }
   }
}