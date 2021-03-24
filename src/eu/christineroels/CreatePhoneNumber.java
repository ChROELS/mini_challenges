package be.intecbrussel.katas;

import java.util.Arrays;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder numbersBuilder = new StringBuilder();
        Arrays.stream(numbers).forEach(numbersBuilder::append);
        numbersBuilder = numbersBuilder.insert(5, '-');
        numbersBuilder = numbersBuilder.insert(2, ") ");
        return "(" + numbersBuilder;
    }

    public static void main(String[] args) {
        //(12) 345-6789
        System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
