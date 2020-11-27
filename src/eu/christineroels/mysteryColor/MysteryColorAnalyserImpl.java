package eu.christineroels.mysteryColor;


import java.util.ArrayList;
import java.util.List;


public class MysteryColorAnalyserImpl implements MysteryColorAnalyser {


    @Override
    public int getNumberOfDistinctColors(List<Color> mysteryColors) {
        //We call colorOccurrence() method to know how many times each color appears in the list
        int amountOfRed = getColorOccurrence(mysteryColors, Color.RED);
        int amountOfBlue = getColorOccurrence(mysteryColors, Color.BLUE);
        int amountOfGreen = getColorOccurrence(mysteryColors, Color.GREEN);
        //We create a list of these color occurrences
        List<Integer> occurrences = new ArrayList<>();
        occurrences.add(amountOfBlue);
        occurrences.add(amountOfGreen);
        occurrences.add(amountOfRed);
        //We calculate how many distinct colors there is in the list, basing ourselves on the occurrences
        int result=3; //maximum three distinct colors possible in our RBG Set
        for(int i = 0; i<occurrences.size();i++){
            //If a color appears 0 times in the list, we can diminish the amount of distinct colors present
            if(occurrences.get(i)==0){
               --result;
            }
        }
        return result;
    }
    @Override
    public int getColorOccurrence(List<Color> mysteryColors, Color color) {
        int total = 0;
        for (Color c: mysteryColors
             ) {
            if(c.equals(color)){
                ++total;
            }
        }
        return total;
    }

}
