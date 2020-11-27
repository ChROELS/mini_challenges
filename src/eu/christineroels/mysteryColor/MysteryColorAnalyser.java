package eu.christineroels.mysteryColor;

import java.util.List;

public interface MysteryColorAnalyser {
    int getNumberOfDistinctColors(List<Color> mysteryColors);
    int getColorOccurrence(List<Color> mysteryColors, Color color);
}
