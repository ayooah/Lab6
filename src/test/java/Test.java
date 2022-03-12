import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    @org.junit.jupiter.api.Test
    void testSingleThreadMult() {
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] arr2 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        assertEquals(100,Util.matrixMultiplication(arr1,arr2)[2][1]);
    }
    @org.junit.jupiter.api.Test
    void timeComparing() {
        int[][] arr1 = Util.createMatrix(1000,1000);
        int[][] arr2 = Util.createMatrix(1000,1500);
        Date start1 = new Date();
        int[][] res1=Util.matrixMultiplication(arr1,arr2);
        Date end1 = new Date();
        double diff1=end1.getTime() - start1.getTime();
        Date start2 = new Date();
        int[][] res2=Util.mtrxMult(arr1,arr2);
        Date end2 = new Date();
        double diff2=end2.getTime() - start2.getTime();
        assertTrue(diff1 > diff2);
    }

}
