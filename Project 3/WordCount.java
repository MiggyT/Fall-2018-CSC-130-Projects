import java.io.IOException;

/**
 * Miguel Tirado, Jesus Nunez 
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

    public static DataCount<String>[] countWords(String struct,String file)throws IOException {
        //DataCounter<String> counter = new BinarySearchTree<String>();
        DataCounter<String> counter; // word counter 
        
        switch(struct) {
            case "-a":
               counter = new AVLTree<>();
               break;
            case "-b":
               counter = new BinarySearchTree<>();
               break;
            case "-h":
               counter = new HashTable();
               break;
            default:
               counter = new BinarySearchTree<>();
               System.out.println("Oops it seems you have entered a Invalid data Structure, so BST is set as default");
               break;
        }
        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }

        DataCount<String>[] counts = counter.getCounts();
        sortByDescendingCount(counts);
        for (DataCount<String> c : counts)
            System.out.println(c.count + " \t" + c.data);
        return counter.getCounts();
    }

    /**
     * TODO Replace this comment with your own.
     * 
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a heap sort
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    private static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                if(counts[j].count < x.count)
                {
                     counts[j + 1] = counts[j];
                     counts[j] = x;
                     continue;
                }
                if(counts[j].count == x.count)
                {
                     if(((String) counts[j].data).charAt(0) < ((String) x.data).charAt(0)) {
                        continue;
                     }
                     else {
                         counts[j+1] = counts[j];
                         counts[j] = x;
                     }
                }
            }
            
        }
    }
    
    private static void numUniqueWords(DataCount<String>[] dcounts) {
         System.out.println("Unique words: " + dcounts.length);
    }
    
    private static void numWordFreq(DataCount<String>[] dcounts) {
         sortByDescendingCount(dcounts);
         System.out.println("Ordered by frequencies:");
         for(DataCount<String> c: dcounts) 
              System.out.println(c.count + " \t" + c.data);
    }
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please enter these three arguments accordingly: [-b | -a | -h] [-frequency | -num_unique] <filename>\n");
            System.out.println("-b - Use an Unbalanced BST");
            System.out.println("-a - Use an AVL Tree");
            System.out.println("-h - Use a Hashtable\n");
            System.out.println("-frequency -print all the words /frequency pairs,ordered by frequency,and then by the words in lexicographic order.");
            System.out.println("-num_unque -print the number of unique words in the document.\nThis is the total number of distinct(different) words in the document. " +
                                "\nWords that appear more than once are only counted as a single word for this statistic");                  
            //System.err.println("Usage: filename of document to analyze");
            System.exit(1);
        }
        try {
            switch(args[1]) {
               case "-frequency":
                  numWordFreq(countWords(args[0], args[2]));
                  break;
               case "-num_unique":
                  numUniqueWords(countWords(args[0], args[2]));
                  break;
               default:
                  System.out.println("Oops wrong choice for second argument");
                  break;
            }
        } catch(IOException e) {
            System.out.println("Oh no, a ERROR has occured when parsing the file.");
            System.out.println(e.getMessage());
        }
    }
}
