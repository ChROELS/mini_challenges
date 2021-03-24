package be.intecbrussel.katas;

import be.intecbrussel.katas.TrollCommentatorAttack;

import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/*Output should be an alphabetical list of all time zones available
* with on the same line the local date and time formatted as followed
* "yyyy-MM-dd HH:mm:ss", as well as the hours difference with
* GMT date and time. It consists thus of three columns: zoneId, local date and time, zoneOffset.
 */
public class ZoneId_ZoneOffSet {
    static Set<String> allZones = ZoneId.getAvailableZoneIds();
    public static List<String> getTableOfTimeZone(){
        List<String> listOfclocks = new ArrayList<>();
        //ordering
        List<String> allZonesSorted = allZones.stream().sorted().collect(Collectors.toList());
        //preparing the output
        String out = null;
        for (String s : allZonesSorted) {
            ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(s));
            ZoneOffset offset = zdt.getOffset();
            DateTimeFormatter nowDateTimeForHumans = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            //output format with two columns (spacing of 35, 25, 10)
            out = String.format("%35s %25s %10s%n", s, zdt.format(nowDateTimeForHumans), offset);
            listOfclocks.add(out);
        }
        return listOfclocks;
    }
    public static void main(String[] args) {
            getTableOfTimeZone().forEach(System.out::println);
        }
    }
