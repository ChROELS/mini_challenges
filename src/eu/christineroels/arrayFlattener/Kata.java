package eu.christineroels.arrayFlattener;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata {
    public static int[] flattenAndSort(int[][] array) {
        //First, let's add each value of the 2D array in a linkedList
        LinkedList<Integer> result = addToList(array);
        //Second, let's create an array based on the linked list
        //This is a method to establish "a bridge" between a list and a array
        Object[] flattenArray = bridgeToArray(result);
        //However, we have to return an int[] array
        //let's create it,
        return switchToIntArray(flattenArray);
    }
    private static LinkedList<Integer> addToList(int[][] array2D){
        LinkedList<Integer> result = new LinkedList<>();
        for (int[] numberArray: array2D
        ) {
            for (int n: numberArray
            ) {
                result.add(n);
            }
        }
        //Second, let's sort these values
        //Comparator needed because numbers does not have a natural ordering
        result.sort(Comparator.comparingInt(Integer::intValue));
        return result;
    }
    private static Object[] bridgeToArray(LinkedList<Integer> list){
        Object[] flattenArray = new Object[list.size()];
        list.toArray(flattenArray);
        return flattenArray;
    }
    private static int[] switchToIntArray(Object[] array){
        //let's have an array
        int[] arrayToReturn = new int[0];
        for(int i=0; i<array.length;i++){
            //replacing it by its longer copy while iterating through flattenArray,
            arrayToReturn = Arrays.copyOf(arrayToReturn,i+1);
            //and let's downcast each objects of the flattenArray that are from the list before assigning them to the arrayToReturn
            if(array[i] instanceof Integer) {
                arrayToReturn[i] = (int) array[i];
            }
        }
        return arrayToReturn;
    }
    public static int[] flattenAndSortWithStream(int[][] array) {
        int[] intermediateArray = Stream.of(array).flatMapToInt(ints -> Arrays.stream(ints).sorted()).toArray();
            return IntStream.of(intermediateArray).sorted().toArray();
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}})));
        System.out.println(Arrays.toString(flattenAndSortWithStream(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}})));
    }
}
