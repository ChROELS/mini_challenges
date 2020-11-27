package eu.christineroels.weightSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WeightSort {
    public static String orderWeight(String strng) {
        System.out.println("numbersOnList as String objects: "+wordsSeparator(strng));
        for (Integer i : parseToListInt(wordsSeparator(strng))
             ) {
            System.out.println("numbersOnList as Integer objects, each: "+ i);
        }
        List<Integer> sumOfDigits = new ArrayList<>();
        for (String s : wordsSeparator(strng)
        ) {
            sumOfDigits.add(getSumOfDigits(s));
        }
        System.out.println(sumOfDigits);
        return strng;
    }
    public static List<Integer> parseToListInt(List<String> numbers){
        List<Integer> numbersOnList = numbers.stream()
                .mapToInt(Integer::parseInt)
                .collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
        return numbersOnList;
    }
    public static List<String> wordsSeparator(String sentence){
        List<String> wordsOnList = new ArrayList<>();
        for (String c: sentence.split(" ")
        ) {
            wordsOnList.add(c);
        }
        return wordsOnList;
    }
    public static int getSumOfDigits(String number){
        int sumOfDigits = 0;
        for (int c = 0; c < number.toCharArray().length;c++){
            int digit = Integer.parseInt(String.valueOf(number.toCharArray()[c]));
            System.out.println("digit: "+digit);
            sumOfDigits+= digit;
            System.out.println("sum of digits: "+sumOfDigits);
        }
        return sumOfDigits;
    }

    public static void main(String[] args) {
        orderWeight("2000 103 123 4444 99");
    }
}
