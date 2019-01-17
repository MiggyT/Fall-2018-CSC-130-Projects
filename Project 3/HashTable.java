/**
 * TODO Replace this comment with your own.
 * Miguel Tirado, Jesus Nunez 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable implements DataCounter<String> {
    private static final int THE_COUNT = 16;
    
    private Node[] storage;
    
    private int size;
    
    public HashTable() {
      this(THE_COUNT);
    }
    
    public HashTable(int tally) {
      this.storage = new Node[tally];
      size = 0;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked") 
    public DataCount<String>[] getCounts() {
        DataCount<String>[] amount = new DataCount[size];
        int i = 0;
        for(Node node : storage) {
            for(; node != null; node = node.next) {
               amount[i++] = new DataCount<>(node.data, node.count);
            }
        }
        // TODO Auto-generated method stub
        return amount;
    }

    /** {@inheritDoc} */
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
        if(findLoadFactor() > 0.75) {
            rehash();
        }
        if(insert(storage, data)) {
            size++;
        }
    }
    private boolean insert(Node[] storage, String data) {
        int hash = hashString(data) % storage.length;
        Node node = storage[hash];
        if(node == null) {
            storage[hash] = new Node(data);
            return true;
        }else {
           while(node != null && !node.data.equals(data)) {
               node = node.next;
           }
           
           if(node == null) {
               storage[hash] = new Node(data, storage[hash]);
               return true;
           }else {
               node.count++;
               return false;
           }
        }
    }
    
    private double findLoadFactor() {
         return (double) size / (double) storage.length;
    }
    
    private void rehash() {
         Node[] storage = new Node[this.storage.length * 2];
         for(Node node : this.storage) {
            for(; node != null; node = node.next) {
                put(storage, node.data, node.count);
            }
         }
         this.storage = storage;
    }
    
    private void put(Node[] storage, String data, int num) {
        int hash = hashString(data) % storage.length;
        Node node = storage[hash];
        if(node != null) {
            while(node != null && !node.data.equals(data)) {
                node = node.next;
            }
            if(node != null) {
                node.count = num;
            }else {
               storage[hash] = new Node(data, storage[hash]);
               storage[hash].count = num;
            }
        }else {
            storage[hash] = new Node(data);
            storage[hash].count = num;
        }
    }
    
    private int hashString(String str) {
      final int mul = 29;
      int sum = 0;
      for(int i=0; i < str.length();i++) {
         sum += str.charAt(i) * mul;
      }
      
      return sum;
    }
    
    private class Node {
      private String data;
      private int count;
      private Node next;
      
      public Node(String data) {
         this(data,null);
      }
      
      public Node(String data, Node next) {
         this.data = data;
         this.count = 1;
         this.next = next;
      }
    }

}