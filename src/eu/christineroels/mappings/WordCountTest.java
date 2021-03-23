package eu.christineroels.mappings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class WordCountTest {

    private static WordCount wordCount;

    @BeforeAll
    static void setUp(){
        wordCount = new WordCount();
    }

    @Test
    void wordCountBasic() {
        Map<String,Integer> results = wordCount.wordCount(new String[]{"c", "b", "a"});
        Assertions.assertAll("mapping", ()->Assertions.assertEquals(1,results.get("a")),
                ()->Assertions.assertEquals(1,results.get("b")),
                ()->Assertions.assertEquals(1,results.get("c")));
    }
    @Test
    void wordCountAllTheSame() {
        Map<String,Integer> results = wordCount.wordCount(new String[]{"c", "c", "c", "c"});
        Assertions.assertAll("mapping and size",
                ()->Assertions.assertEquals(4,results.get("c")),
                ()->Assertions.assertEquals(1,results.size()));
    }
    @Test
    void wordCountRandom() {
        Map<String,Integer> results = wordCount.wordCount(new String[]{"a", "b", "a", "c", "b"});
        Assertions.assertAll("mapping and size",
                ()->Assertions.assertEquals(2,results.get("b")),
                ()->Assertions.assertEquals(2,results.get("a")),
                ()->Assertions.assertEquals(1,results.get("c")),
                ()->Assertions.assertEquals(3,results.size()));
    }
}