package P1TO50.P48;

public class P48_RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i<n/2;i++){
            for(int j = 0;j<n-2*i-1;j++){
                int temp = matrix[i+j][n-i-1];
                matrix[i+j][n-i-1] = matrix[i][i+j];

                int temp2 = matrix[n-i-1][n-i-1-j];
                matrix[n-i-1][n-i-1-j] = temp;

                temp = matrix[n-i-1-j][i];
                matrix[n-i-1-j][i] = temp2;

                matrix[i][i+j] = temp;
            }
        }
    }
}
