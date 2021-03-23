package eu.christineroels.whichAreIn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> uniqueElementsResult = new HashSet<>();
        for (String el1: array1
             ) {
            for (String el2: array2
                 ) {
                if(el2.contains(el1)){
                    uniqueElementsResult.add(el1);
                }
            }
        }
        return uniqueElementsResult.stream().sorted().toArray(String[]::new);
    }


}
