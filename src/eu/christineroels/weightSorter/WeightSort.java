package eu.christineroels.weightSorter;

import java.util.*;
import java.util.stream.IntStream;

public class WeightSort {
    public static String orderWeight(String strng) {
        Map<Integer,String> mapOfNumbersWeights = new TreeMap<>();
        List<String> listOfStringNumbers;
        List<String> numbersSameWeights = new ArrayList<>();
        List<Integer> sumOfDigits = new ArrayList<>();
        //Create a list of separate 'numbers', on the basis of a string representation of a list of numbers
        listOfStringNumbers= wordsSeparator(strng);
        System.out.println("numbersOnList as String objects: "+listOfStringNumbers);
        //Create a list of the sum of digits of each separate 'numbers'
        for (String s : wordsSeparator(strng)
        ) {
            sumOfDigits.add(getSumOfDigits(s));
        }
        System.out.println(sumOfDigits);
        //create a list of numbers that have the same sum of digits


        //Create a map associating each number with its corresponding sum of digits
        //We can only have unique numbers in the list!
        for(int i = 0; i<sumOfDigits.size(); i++) {
            mapOfNumbersWeights.put(sumOfDigits.get(i), listOfStringNumbers.get(i));
        }
        mapOfNumbersWeights.forEach((k,v) -> System.out.printf("Sum of its digits: %d, number: %s. %n",k,v));
        //ordering list of sum of digits
        sumOfDigits.sort(Integer::compareTo);
        System.out.println(sumOfDigits);
        //Create a list of String numbers reordered according to their 'weight' with the help of the map
        List<String> listReorderedNumbers = new ArrayList<>();
        for (Integer sum: sumOfDigits
             ) {
            String correspondingNumber = mapOfNumbersWeights.get(sum);
            listReorderedNumbers.add(correspondingNumber);
        }
        System.out.println(listReorderedNumbers);
        //Create a string representation of the reordered list
        StringBuilder reversedNumbers = new StringBuilder();
        for (String n: listReorderedNumbers
             ) {
            reversedNumbers.append(n).append(" ");
        }
        reversedNumbers.deleteCharAt(reversedNumbers.length()-1);
        System.out.println("Starting with = "+strng);
        System.out.println("Result = "+reversedNumbers.toString());
        return reversedNumbers.toString();
    }
    public static List<Integer> parseToListInt(List<String> numbers){
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
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
    public static List<String> getListSameWeights(List<String> numbers, List<Integer> sumOfDigits){
        List<String> numbersSameWeights = new ArrayList<>();
        for(int i = 0; i<sumOfDigits.size(); i++) {
            for (String g: numbers
        ) {
                if (getSumOfDigits(g) == sumOfDigits.get(i)) {
                    numbersSameWeights.add(g);
                    System.out.println(numbersSameWeights);
                    break;

                }
            }
        }
        return numbersSameWeights;
    }

    public static void main(String[] args) {
        getListSameWeights(wordsSeparator("2000 10003 1234000 44444444 9999 11 11 40 123"),List.of(2,4,10,32,36,2,2,4,6));
        //orderWeight("2000 10003 1234000 44444444 9999 123");
    }
}
