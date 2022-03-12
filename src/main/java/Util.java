import java.util.ArrayList;
import java.util.List;
/**
 * Class for working with matrices
 * @autor Anna Ushakova
 */
public class Util {
    /**
     * Single-threaded matrix multiplication
     * @param arr1 left matrix
     * @param arr2 right matrix
     */
    public static int[][]  matrixMultiplication(int[][] arr1, int[][] arr2){
        int[][] res=new int[arr1.length][arr2[0].length];
        int sumCol;
        for (int i=0;i<arr1.length;i++){
            for (int k=0;k<arr2[0].length;k++){
                sumCol=0;

                for (int j=0;j< arr2.length;j++){
                    sumCol+=arr1[i][j]*arr2[j][k];
                }
                res[i][k]=sumCol;
            }
        }
        return res;
    }
    public static int[][] createMatrix(int rows,int columns){
        int[][] arr=new int[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                arr[i][j]= (int) (Math.random() * 20 - 10);
            }
        }
        return arr;
    }
    /**
     * Matrix multiplication using the number of threads available to the processor
     * @param arr1 left matrix
     * @param arr2 right matrix
     */
    public static int[][] mtrxMult(int[][] arr1, int[][] arr2){
        List threads = new ArrayList<>();
        int[][] res=new int[arr1.length][arr2[0].length];
        for (int i=0;i<arr1.length;i++){
            RowMultiplication rm=new RowMultiplication(arr1[i],arr2,res,i );
            Thread thread = new Thread(rm);
            thread.start();
            threads.add(thread);
            if (threads.size() % Runtime.getRuntime().availableProcessors() == 0) {
                waitThread(threads);
            }
        }
        return res;
    }
    private static void waitThread(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}




