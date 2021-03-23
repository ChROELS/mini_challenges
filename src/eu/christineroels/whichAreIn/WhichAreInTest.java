package eu.christineroels.whichAreIn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WhichAreInTest {
    @Test
    public void areIn() {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }
    @Test
    public void areNotIn() {
        String a[] = new String[]{ "tarp", "mice", "bull" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { };
        assertArrayEquals(r, WhichAreIn.inArray(a, b));
    }

}
