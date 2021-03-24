package be.intecbrussel.katas;
/*
*Logarithm to insert letters of the alphabet coming after each letter of a given word
* in a format "letterALPHALETTER"
 */
public class InsertMissingLetters {
    public static String insertMissingLetters(String str) {
        //One alphabet as a StringBuilder
        StringBuilder alphabet1 = new StringBuilder(String.valueOf(new char[]{'A', 'B', 'C', 'D'}));
        alphabet1.append(String.valueOf(new char[]{'E', 'F', 'G', 'H'}))
                .append(String.valueOf(new char[]{'I', 'J', 'K', 'L'}))
                .append(String.valueOf(new char[]{'M', 'N', 'O', 'P'}))
                .append(String.valueOf(new char[]{'Q', 'R', 'S', 'T'}))
                .append(String.valueOf(new char[]{'U', 'V', 'W'}))
                .append(String.valueOf(new char[]{'X', 'Y', 'Z'}));
        //A StringBuilder based on the given word(str)
        StringBuilder result = new StringBuilder(str);
        //The given word as an char array
        char[] word = str.toCharArray();
        //A variable amount of alphabet letters after each letter of the given word
        String alphabetFollowingLetter = null;
        //Going from the last letter to the first letter in the given word
        for (int i = word.length - 1; i >= 0; i--) {
            final String strLetter = String.valueOf(word[i]).toUpperCase();
            //Precaution (if word letters are not in the alphabet
            // it will not find them)
            if (alphabet1.toString().contains(strLetter)) {
                // and targeting alphabet letters after 'strLetter'
                alphabetFollowingLetter = alphabet1.substring(alphabet1.indexOf(strLetter)+1);
                //Inserting in the "StringBuilder based on the given word", starting from the last letter
                 result.insert(i + 1, alphabetFollowingLetter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //mNOPQRSTUVWXYZaBCDEFGHIJKLMNOPQRSTUVWXYZrSTUVWXYZkLMNOPQRSTUVWXYZtUVWXYZ
        System.out.println(insertMissingLetters("markt"));
        //mNOPQRSTUVWXYZaBCDEFGHIJKLMNOPQRSTUVWXYZ@
        System.out.println(insertMissingLetters("ma@"));
        //mNOPQRSTUVWXYZaBCDEFGHIJKLMNOPQRSTUVWXYZ1345
        System.out.println(insertMissingLetters("ma1345"));
    }
}
