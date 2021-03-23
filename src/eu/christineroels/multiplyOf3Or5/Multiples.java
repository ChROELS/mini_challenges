package eu.christineroels.multiplyOf3Or5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Multiples {

    public int getSumOfMultiples(int numberLimit){
        return IntStream.range(0,numberLimit).filter(i -> i%3==0||i%5==0).sum();
    }
}
