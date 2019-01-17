/* Miguel Tirado, Jesus Nunez 
 * CSC 130, Project 3 
 * Date: 10/24/2018  */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Correlator {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: [-b | -a | -h] <filename 1> <filename 2>\n");
            System.out.println("-b Use an unbalanced BST in the backend");
            System.out.println("-a Use an AVL Tree in the backend");
            System.out.println("-h Use a Hashtable in the backend");
            return;
        }
        double i = (double)System.currentTimeMillis();
        DataCount<String>[] count1;
        DataCount<String>[] count2;

        try {
            count1 = WordCount.countWords(args[0], args[1]);
            count2 = WordCount.countWords(args[0], args[2]);
        } catch(IOException e) {
            System.out.println("An error occurred while parsing the files!");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nDifference metric: " + differenceMetric(count1, count2));
        double tTime = ((double)(System.currentTimeMillis() - i)/1000);
        System.out.println("run time: " + tTime + " Seconds");
    }

    /**
     * Counts total words in an array of data counts.
     *
     * @param Data counts
     * @return Total words
     */
    private static int getTotalCount(DataCount<String>[] dataCounts) {
        int tWords = 0;
        for(DataCount<String> dataCount : dataCounts) {
            tWords += dataCount.count;
        }
        return tWords;
    }

    /**
     * Returns frequency of string in an array of data counts, providing
     * the frequency is {@code 0.0001 < x < 0.01}.
     *
     * @param array of data counts
     * @return Strings frequency
     */
    private static Map<String, Double> frequency(DataCount<String>[] dataCounts) {
        double totalCount = (double) getTotalCount(dataCounts);
        Map<String, Double> freqs = new HashMap<>();
        for(DataCount<String> dataCount : dataCounts) {
            double freq = (double) dataCount.count / totalCount;
            if(freq < 0.01 && freq > 0.0001) {
                System.out.format("%s - %f\n", dataCount.data, freq);
                freqs.put(dataCount.data, freq);
            }
        }
        return freqs;
    }

    /**
     * Calculates the difference between two documents.
     *
     * @param First document
     * @param Second document
     * @return The difference both documents
     */
    private static double differenceMetric(DataCount<String>[] dataCounts1, DataCount<String>[] dataCounts2) {
        System.out.println("Frequencies for first file:");
        Map<String, Double> freqs1 = frequency(dataCounts1);

        System.out.println("\nFrequencies for second file:");
        Map<String, Double> freqs2 = frequency(dataCounts2);

        double sum = 0;
        for(String key : freqs1.keySet()) {
            if(freqs2.containsKey(key)) {
                double d = Math.abs(freqs1.get(key) - freqs2.get(key)); //difference
                sum += d * d;
            }
        }
        return sum;
    }
}