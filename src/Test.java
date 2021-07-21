import java.util.HashMap;
import java.util.Scanner;

public class Test {

    public void myMethod() {
        System.out.println("class test");
    }

    public void someMethod(){
        System.out.println("some method in class test");
    }

    public static void someMethod(int a){
        System.out.println("some method in class test");
    }

    public static void someMethod(String c){
        System.out.println("some method in class test");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();                 // Reading input from STDIN
        String[] a = size.split(" ");
        int n = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        int matrix[][] = new int[n][m];
        for (int i = 0; i < n; i ++) {
            String rowData = s.nextLine();
            String[] rd = rowData.split(" ");
            for (int j = 0; j < m; j ++) {
                matrix[i][j] = Integer.parseInt(rd[j]);
            }
        }
        int[][] prefixSum = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                prefixSum[i][j] = matrix[i][j];
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++)
                prefixSum[i][j] += prefixSum[i][j-1];
        }

        int maxSize = 0;
        for(int firstCol=0;firstCol<m;firstCol++){
            for(int secondCol=firstCol;secondCol<m;secondCol++){
                int tmp[] = new int[n]; // stores the sum between two columns for each row
                for(int row=0;row<n;row++)
                    tmp[row] = prefixSum[row][secondCol] - (firstCol>0 ? prefixSum[row][firstCol-1] : 0);

                int curSum = 0;
                HashMap<Integer, Integer> rowSumMap = new HashMap<>();
                rowSumMap.put(0,-1);
                for(int curRow=0;curRow<n;curRow++){
                    curSum += tmp[curRow];
                    if(rowSumMap.containsKey(curSum)) {
                        int subMatrixSize = (secondCol - firstCol + 1)*(curRow - rowSumMap.get(curSum));
                        if(subMatrixSize > maxSize){
                            maxSize = subMatrixSize;
                        }
                    } else {
                        rowSumMap.put(curSum,curRow);
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
