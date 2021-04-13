package src.main;

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

        
        String fileName = "letterfrequencies/src/main/resources/FoundationSeries.txt";
        Reader reader = new FileReader(fileName);
        Map<Integer, Long> freq = new HashMap<>();
        timer.start();
        tallyChars(reader, freq);
        long step = timer.step();
        System.out.println("Tally chars execution time: " + step / 1_000_000 + "ms");

        print_tally(freq);

        long stop = timer.stop();
        System.out.println("Tally chars execution time: " + stop / 1_000_000 + "ms");
    }

    private static void tallyChars(Reader reader, Map<Integer, Long> hashmap) throws IOException {
        hashmap = prepareHashmap(hashmap);
        int b;
        
        while ((b = reader.read()) != -1) {
            // 97=76012 = A
            // 122=674 = Z
            if(b < 97 || b > 122) continue;
            
            hashmap.put(b, hashmap.get(b) + 1);
        }


    }

    private static void print_tally(Map<Integer, Long> freq) {
        int dist = 'a' - 'A';
        Map<Character, Long> upperAndlower = new LinkedHashMap();
        for (Character c = 'A'; c <= 'Z'; c++) {
            upperAndlower.put(c, freq.getOrDefault(c, 0L) + freq.getOrDefault(c + dist, 0L));
        }
        Map<Character, Long> sorted = upperAndlower
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        for (Character c : sorted.keySet()) {
            System.out.println("" + c + ": " + sorted.get(c));;
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

