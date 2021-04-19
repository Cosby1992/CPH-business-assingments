package src.main.benchmark.benchmark_classes;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class OriginalForBenchmark {
    
    
    public static void tallyChars(Reader reader, Map<Integer, Long> frequencyMap) throws IOException {
        int b;
        while ((b = reader.read()) != -1) {
            try {
                frequencyMap.put(b, frequencyMap.get(b) + 1);
            } catch (NullPointerException np) {
                frequencyMap.put(b, 1L);
            };
        }
    }

    public static void print_tally(Map<Integer, Long> freq) {
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



}
