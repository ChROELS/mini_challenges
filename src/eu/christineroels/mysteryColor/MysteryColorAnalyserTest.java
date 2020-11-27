package eu.christineroels.mysteryColor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MysteryColorAnalyserTest {
    private List<Color> mysteryColors;
    private MysteryColorAnalyserImpl mysteryColorAnalyser;
    @Before
    public void initializeList(){
        mysteryColors = new ArrayList<>();
    }
    @Before
    public void initializeAnalyser(){
        mysteryColorAnalyser= new MysteryColorAnalyserImpl();
    }
    //3 cases for method colorOccurence()
    @Test
    public void testColorOccurrenceOfColorPresentTwoTimes() {
        //Arrange
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.GREEN);
        Color color = Color.RED;
        //Act
        int result = mysteryColorAnalyser.getColorOccurrence(mysteryColors, color);
        //Assert
        assertEquals("Method colorOccurence() does not work",2, result);
    }
    @Test
    public void testColorOccurrenceOfColorPresentOneTime() {
        //Arrange
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.BLUE);
        mysteryColors.add(Color.GREEN);
        Color color = Color.RED;
        //Act
        int result = mysteryColorAnalyser.getColorOccurrence(mysteryColors, color);
        //Assert
        assertEquals("Method colorOccurence() does not work",1, result);
    }
    @Test
    public void testColorOccurrenceOfColorAbsent() {
        //Arrange
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.GREEN);
        mysteryColors.add(Color.GREEN);
        Color color = Color.BLUE;
        //Act
        int result = mysteryColorAnalyser.getColorOccurrence(mysteryColors, color);
        //Assert
        assertEquals("Method colorOccurence() does not work",0, result);
    }
    //3 cases for method numberOfDistinctColors()
    @Test
    public void testNumberOfDistinctColorsWithDifferentColors(){
        //Arrange
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.GREEN);
        //Act
        int result = mysteryColorAnalyser.getNumberOfDistinctColors(mysteryColors);
        //Assert
        assertEquals("Method numberOfDistinctColors() does not work",2,result);
    }
    @Test
    public void testNumberOfDistinctColorsWithOneColor(){
        //Arrange
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.RED);
        mysteryColors.add(Color.RED);
        //Act
        int result = mysteryColorAnalyser.getNumberOfDistinctColors(mysteryColors);
        //Assert
        assertEquals("Method numberOfDistinctColors() does not work",1,result);
    }
    @Test
    public void testNumberOfDistinctColorsWithNoColors(){
        //Arrange
        //Act
        int result = mysteryColorAnalyser.getNumberOfDistinctColors(mysteryColors);
        //Assert
        assertEquals("Method numberOfDistinctColors() does not work",0,result);
    }
}
