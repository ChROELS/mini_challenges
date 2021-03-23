package eu.christineroels.mappings;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class WordCountVariation {
    public static void main(String[] args) {
        System.out.println(wordAppend(new String[]{"a","b","a"}));
        System.out.println(wordAppend(new String[]{"a","b","a","b"}));
        System.out.println(wordAppend(new String[]{"a", "b", "a", "c", "a", "d", "a"}));
    }
    public static String wordAppend(String[] strings) {
        StringBuilder result = new StringBuilder();
        Set<String> arraySingles = arrayToSetNoDuplicates(strings);
        for (String word: arraySingles
        ) {
            int savedValue = arrayElementsMapping(strings).get(word);
            if(savedValue!=0){
                boolean flag;
                //if there is an impair number of appearances of the word in the source array --> first lower pair number
                if (savedValue % 2 != 0) {
                    savedValue--;
                }
                do{
                    //We append the word if it appears at least 2 times in the source array
                    if(savedValue>=2) {
                        //To do ordering the append by the order of word appearances in the array like 'first 2 or more appearances'
                        result.append(arraySingles.stream().filter(s -> s.equals(word)).findFirst().get());
                    }
                        flag = (savedValue / 2) > 1;
                        savedValue--;

                }while(flag);
            }
        }
        return result.toString();
    }
    public static Set<String> arrayToSetNoDuplicates(String[] strings){
        Set<String> arraySingles = new LinkedHashSet<>();
        Collections.addAll(arraySingles, strings);
        return arraySingles;
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
