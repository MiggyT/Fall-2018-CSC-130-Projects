public class TestTree {
   public static void main (String[] args) {
      BSTree tree = new BSTree();
      //System.out.println(tree.isEmpty());
      /*tree.insert(8);
      tree.insert(4);
      tree.insert(10);
      tree.insert(2);
      tree.insert(5); */
      //tree.inOrder();
      tree.insert(4); 
      tree.insert(2);
      tree.insert(2);
      tree.insert(2);
      tree.insert();
      tree.insert(4.5);
      tree.insert("sjdfnjgehj");
      tree.insert(true);
      tree.inOrder();
      System.out.println(tree.contains(6));
       System.out.println(tree.isEmpty());
   }
}