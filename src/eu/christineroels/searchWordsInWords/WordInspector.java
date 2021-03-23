package eu.christineroels.searchWordsInWords;

import java.util.Map;
import java.util.TreeMap;

public class WordInspector {

    public static Map<String,Map<String,Integer>> countOccurrence(String originalWord, String wordToSearchFor){
        Map<String,Integer> wordAndXWordInside = new TreeMap<>();
        Map<String,Map<String,Integer>> result = new TreeMap<>();
        int total = 0;
        String containerWord = originalWord;
        while(containerWord.contains(wordToSearchFor)){
            //If it contains the word we are looking for, it has at least one occurrence
            total++;
            //But does it have more than one time the word we are looking for?
            //let's say we are looking for "snow"
            //let's consider the index of the first occurrence of "snow" in our given word
            int indexOfWord = containerWord.indexOf(wordToSearchFor);
            //Case 1: "snow" is at the start of our word
            if(indexOfWord==0) {
                //let's update our variable with a new value:
                //what's remain from our given word without this special occurrence of "snow"
                containerWord = containerWord.substring(indexOfWord + wordToSearchFor.length());
            }else{
                // Other case: "snow" is somewhere inside the word
                //If "snow" is not positioned at the start of the word, we will have to update
                //our variable with what is before and after this first occurrence of "snow"
                StringBuilder sb = new StringBuilder();
                String beforeWordToFind = containerWord.substring(0,indexOfWord);
                sb.append(beforeWordToFind);
                String afterWordToFind = containerWord.substring(indexOfWord+ wordToSearchFor.length());
                sb.append(afterWordToFind);
                //Now, we update our variable 'containerWord' to make the while loop continue and repeat the procedure
                containerWord = sb.toString();
            }
        }
        //Once we have count all the occurrences and isolate what remains of the original word
        //We may update our first map
        wordAndXWordInside.putIfAbsent(containerWord,total);
        //We would like to return a mapping of the original word, it's remaining characters once passed to the loop
        // and how many times we have found the given expression (like "snow") within it
        result.putIfAbsent(originalWord,wordAndXWordInside);
        return result;
    }
    public static String getRemainingWordInBetween(String originalWord, String wordToSearchFor){
        StringBuilder response = new StringBuilder(originalWord);
        int firstIndex = response.indexOf(wordToSearchFor);
        System.out.println("First index: "+firstIndex);
        int lastIndex = response.lastIndexOf(wordToSearchFor);
        System.out.println( "last index: "+ lastIndex);
        return response.substring(firstIndex + wordToSearchFor.length(),lastIndex);
    }

    public static void main(String[] args) {
        System.out.println(countOccurrence("xxbreadjambreadyy","bread"));
        System.out.println(countOccurrence("\"xxbreadyy\"","bread"));
        System.out.println("*".repeat(10));
        System.out.println(getRemainingWordInBetween("breadjambread","bread"));
    }
}
