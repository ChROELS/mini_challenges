package eu.christineroels.searchWordsInWords;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class WordInspectorTest {
    Map<String,Integer> actualValue;
    Map<String, Map<String,Integer>> expectedMap;
    @Before
    public void arrange(){
        actualValue = new TreeMap<>();
        expectedMap = new TreeMap<>();
    }
    @Test
    public void testCountOccurrenceStart(){
        //Arrange
        actualValue.putIfAbsent("plough",1);
        expectedMap.put("snowplough",actualValue);
        //Act
        Map<String, Map<String,Integer>> test1;
        test1 = WordInspector.countOccurrence("snowplough","snow");
        //Assert
        Assert.assertEquals(test1, expectedMap);
    }
    @Test
    public void testCountOccurrencesMultiple(){
        //Arrange
        actualValue.putIfAbsent("",4);
        expectedMap.put("snowsnowsnowsnow",actualValue);
        //Act
        Map<String, Map<String,Integer>> test1;
        test1 = WordInspector.countOccurrence("snowsnowsnowsnow","snow");
        //Assert
        Assert.assertEquals(test1, expectedMap);
    }
    @Test
    public void testCountOccurrencesNone(){
        //Arrange
        actualValue.putIfAbsent("rain",0);
        expectedMap.put("rain",actualValue);
        //Act
        Map<String, Map<String,Integer>> test1;
        test1 = WordInspector.countOccurrence("rain","snow");
        //Assert
        Assert.assertEquals(test1, expectedMap);
    }
    @Test
    public void testCountOccurrencesVariable(){
        //Arrange
        actualValue.putIfAbsent("*rain**sunny*",2);
        expectedMap.putIfAbsent("*rain*snow*sunny*snow",actualValue);
        //Act
        Map<String, Map<String,Integer>> test1;
        test1 = WordInspector.countOccurrence("*rain*snow*sunny*snow","snow");
        //Assert
        Assert.assertEquals(test1, expectedMap);
    }
    @After
    public void output(){
        System.out.println("The content of the expected map is rewritten in each test case: "+ expectedMap);
    }
}
