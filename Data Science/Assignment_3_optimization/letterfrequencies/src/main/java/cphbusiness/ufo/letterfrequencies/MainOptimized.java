package cphbusiness.ufo.letterfrequencies;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Frequency analysis Inspired by
 * https://en.wikipedia.org/wiki/Frequency_analysis
 *
 * @author kasper
 * Optimized by Cosby and Stabz
 * 
 */
public class MainOptimized {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Timer timer = new Timer();

        
        String fileName = "C:\\Users\\Support\\IdeaProjects\\CPH-business-assingments\\Data Science\\Assignment_3_optimization\\letterfrequencies\\src\\main\\resources\\FoundationSeries.txt";
        Reader reader = new FileReader(fileName);
        int[] freq =
                {0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,
                 0,0,0,0,0,0};
        timer.start();
        tallyChars(reader, freq);
        long step = timer.milliNow();
        System.out.println("Tally chars execution time: " + step + "ms");

        print_tally(freq);
        long stop = timer.milliNow();
        System.out.println("Tally chars execution time: " + stop + "ms");
    }

    private static void tallyChars(Reader reader, int[] integerArray) throws IOException {
        //hashmap = prepareHashmap(hashmap);
        int b;

        /**
         E          T         A         O         N
         I         S         R         H         D
         L         U         C         M         Y
         F         W         G         P         B
         V         K         X         Q         J
         Z
         */
        
        while ((b = reader.read()) != -1) {
            // 97=76012 = A
            // 122=674 = Z
            b= b-97;
            if(b < 0 || b > 25) continue;
            integerArray[b] += 1;
           // hashmap.put(b, hashmap.get(b) + 1);
        }


    }

    private static void print_tally(int[] freq) {

        for (int i = 0; i<freq.length; i++){
            char letter = (char) (i+97);
            System.out.println("Letter: "+letter+" is present "+freq[i]+" times");
        }

    }

    private static Map<Integer, Long> prepareHashmap(Map<Integer, Long> map) {

        //0 - 65535
        for (int i = 0; i < 65536; i++) {
            map.put(i, 0L);
        }

        return map;
    }
}

