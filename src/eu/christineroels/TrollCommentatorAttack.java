package be.intecbrussel.katas;
/*We have a message, a string and we want to make all the vowels it contains
*disappear. We have to return the same message without vowels "a-e-i-o-u".
 */
public class TrollCommentatorAttack {
    public static void main(String[] args) {
        String str = "hahaha, I am a trOll! []";
        System.out.println(str);
        System.out.println(disemvowel(str));

    }
    public static String disemvowel(String str) {
        String vowelsTogether = "aeiou";
        char[] vowels = vowelsTogether.toCharArray();
        char[] capitalVowels = vowelsTogether.toUpperCase().toCharArray();
        StringBuilder sBuilding = new StringBuilder();
        for (String s: str.split(" ")
             ) {
            sBuilding.append(s);
            for (char t: s.toCharArray()
            ) {
                for (char v: vowels
                ) {
                    if(t==v){
                        int indexOfVowel = sBuilding.toString().indexOf(t);
                        sBuilding.deleteCharAt(indexOfVowel);
                    }
                }
                for (char vCapital: capitalVowels
                     ) {
                    if(t==vCapital){
                        int indexOfVowel = sBuilding.toString().indexOf(t);
                        sBuilding.deleteCharAt(indexOfVowel);
                    }
                }
            }
            sBuilding.append(" ");
        }
        return sBuilding.toString();
    }
}
