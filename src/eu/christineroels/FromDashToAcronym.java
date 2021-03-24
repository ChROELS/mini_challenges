package be.intecbrussel.katas;

public class FromDashToAcronym {
    public static void main(String[] args) {
        String word1 =  "the-stealth-warrior";
        System.out.println(toAcronym(word1));
    }
    public static String toAcronym(String s) {
        String[] wordParts = s.split("-");
        StringBuilder result = new StringBuilder();
        for (String w : wordParts
        ) {
            w = w.substring(0, 1).toUpperCase();
            result.append(w);
        }
        return result.toString();
    }
}
