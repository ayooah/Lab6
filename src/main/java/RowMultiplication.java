/**
 * Class for multiplying a row by a matrix
 * @autor Anna Ushakova
 */
public class RowMultiplication implements Runnable{
    int[] row;
    int[][] arr2;
    int[][] res;
    int pos;
    public RowMultiplication(int[] row,int[][] arr2,int[][] res,int pos) {
        this.arr2=arr2;
        this.row=row;
        this.pos=pos;
        this.res=res;
    }

    @Override
    public void run() {
        int sumCol;
        for (int k=0;k<arr2[0].length;k++){
            sumCol=0;

            for (int j=0;j< arr2.length;j++){
                sumCol+=row[j]*arr2[j][k];
            }
            res[pos][k]=sumCol;
        }
    }
}
