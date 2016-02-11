package eu.elision.hashcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceUtilTest {

    @Test
    public void testDistance() throws Exception {
        System.out.println(DistanceUtil.distance(10, 10, 0, 0));
    }

    @Test
    public void testCost() throws Exception {
        System.out.println(DistanceUtil.cost(10, 10, 0, 0));
    }
}
