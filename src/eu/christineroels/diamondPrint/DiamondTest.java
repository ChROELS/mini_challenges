package eu.christineroels.diamondPrint;

import org.junit.Assert;
import org.junit.Test;

public class DiamondTest {
    @Test
    public void testDiamond3(){
        StringBuilder builder = new StringBuilder();
        builder.append(" *\n");
        builder.append("***\n");
        builder.append(" *\n");
        Assert.assertEquals(builder.toString(), Diamond.print(3));
    }
    @Test
    public void testDiamond5() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        Assert.assertEquals(expected.toString(), Diamond.print(5));
    }

    @Test
    public void testDiamond1() {
        StringBuffer expected = new StringBuffer();
        expected.append("*\n");
        Assert.assertEquals(expected.toString(), Diamond.print(1));
    }

    @Test
    public void testDiamond0() {
        Assert.assertEquals(null, Diamond.print(0));
    }

    @Test
    public void testDiamondMinus2() {
        Assert.assertEquals(null, Diamond.print(-2));
    }

    @Test
    public void testDiamond2() {
        Assert.assertEquals(null, Diamond.print(2));
    }
}
