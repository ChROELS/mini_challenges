package eu.christineroels.multiplyOf3Or5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MultiplesOf3Or5Test {

    @Test
    public void under23(){
        Assertions.assertEquals(23, new Multiples().getSumOfMultiples(10));
    }
}
