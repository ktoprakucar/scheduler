package calculation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {

    @Test
    public void should_calculate_gcd_two() {
        //given
        int[] numberList = {2, 4, 8};

        //when
        int gcd = MathUtil.gcd(numberList);

        //then
        assertEquals(gcd, 2);
    }

    @Test
    public void should_calculate_gcd_one() {
        //given
        int[] numberList = {3, 4, 8};

        //when
        int gcd = MathUtil.gcd(numberList);

        //then
        assertEquals(gcd, 1);
    }

    @Test
    public void should_calculate_lcm_six() {
        //given
        int[] numberList = {3, 6, 2};

        //when
        int gcd = MathUtil.lcm(numberList);

        //then
        assertEquals(gcd, 6);
    }

    @Test
    public void should_calculate_lcm_1716() {
        //given
        int[] numberList = {13, 12, 11};

        //when
        int gcd = MathUtil.lcm(numberList);

        //then
        assertEquals(gcd, 1716);
    }
}
