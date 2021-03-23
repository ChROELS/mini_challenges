package eu.christineroels.unluckyDays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnluckyDaysTest {
        @Test
        public void testSomething() {
            assertEquals(3, UnluckyDays.unluckyDays(2015));
            assertEquals(1, UnluckyDays.unluckyDays(1986));
            assertEquals(1, UnluckyDays.unluckyDays(6507));
            assertEquals(2, UnluckyDays.unluckyDays(4024));
            assertEquals(1, UnluckyDays.unluckyDays(1025));
        }
}
