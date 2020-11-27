package eu.christineroels.lineNumbering;
import java.util.*;

public class LineNumbering {
    public static List<String> number(List<String> lines) {
        List<String> listOfNumberedLines = new ArrayList<>();
        StringBuilder numbLine;
        int number = 1;
        for (String line: lines
             ) {
            numbLine = new StringBuilder(line);
            numbLine.insert(0,number+": ");
            listOfNumberedLines.add(numbLine.toString());
            number++;
        }
        return listOfNumberedLines;
    }
}

