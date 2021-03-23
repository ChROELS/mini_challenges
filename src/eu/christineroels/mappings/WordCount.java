package eu.christineroels.mappings;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> results = new HashMap<>();
        for(String s:strings){
            Integer count = 0;
            for (String string : strings) {
                if (string.equals(s)) {
                    count++;
                }
            }
            results.put(s,count);
        }
        return results;
    }
    public static Map<String,Integer> arrayElementsMapping(String[] strings){
        Map<String,Integer> counts = new HashMap<>();
        int amountOfTimesItAppears;
        for(String word: strings){
            amountOfTimesItAppears = 0;
            for (String string : strings) {
                if (string.equals(word)) {
                    amountOfTimesItAppears++;
                }
            }
            if(!counts.containsKey(word)) {
                counts.put(word, amountOfTimesItAppears);
            }
        }
        return counts;
    }
}
