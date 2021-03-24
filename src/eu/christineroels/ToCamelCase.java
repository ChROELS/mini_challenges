package be.intecbrussel.katas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ToCamelCase {
    public static void main(String[] args) {
        String word1 =  "the-stealth-warrior";
        String word2 = "The_Stealth_Warrior";
        System.out.println(toCamelCase(word1));
        System.out.println(toCamelCase(word2));
    }
    public static String toCamelCase(String s){
        //I will have strings containing "-" or "_" between each words
        String[] wordParts = s.contains("-")?s.split("-"):s.split("_");
        //Creating the camelCase version of the given string
        StringBuilder result = new StringBuilder();
        List<String> upperCaseLetters = new ArrayList<>();
        List<String> restOfLetters = new ArrayList<>();
        if(s.length()==0){
            return s;
        }else {
            for (String w : wordParts
            ) {
                upperCaseLetters.add(w.substring(0, 1).toUpperCase());
                String withoutFirstLetter = w.substring(1);
                restOfLetters.add(withoutFirstLetter);
            }
            for (int i = 0; i < upperCaseLetters.size(); i++) {
                result.append(upperCaseLetters.get(i)).append(restOfLetters.get(i));
            }
            //Lowering the case of the first letter of the future camelCase word
            String firstLetter = result.substring(0, 1).toLowerCase();
            result = result.deleteCharAt(0).insert(0, firstLetter);

        }
        return result.toString();
    }
}