package eu.elision.hashcode;

import org.apache.commons.math3.ml.distance.EuclideanDistance;

public class DistanceUtil {

    private static EuclideanDistance euclideanDistance = new EuclideanDistance();

    public static double distance(int x1, int y1, int x2, int y2) {
        return euclideanDistance.compute(new double[] {x1, y1}, new double[] {x2, y2});
    }

    public static int cost(int x1, int y1, int x2, int y2) {
        return (int) Math.ceil(distance(x1, y1, x2, y2));
    }
}
