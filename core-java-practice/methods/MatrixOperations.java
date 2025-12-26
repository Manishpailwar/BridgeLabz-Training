import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        // Example usage
        int[][] m1 = createRandomMatrix(2, 2);
        int[][] m2 = createRandomMatrix(2, 2);

        System.out.println("Matrix 1:");
        displayMatrix(m1);
        System.out.println("Matrix 2:");
        displayMatrix(m2);

        System.out.println("Addition:");
        displayMatrix(add(m1, m2));

        System.out.println("Multiplication:");
        displayMatrix(multiply(m1, m2));

        System.out.println("Transpose of M1:");
        displayMatrix(transpose(m1));

        System.out.println("Determinant of M1 (2x2): " + determinant2x2(m1));
        
        System.out.println("Inverse of M1 (2x2):");
        double[][] inv = inverse2x2(m1);
        if (inv != null) {
            for(double[] row : inv) {
                for(double val : row) System.out.printf("%.2f ", val);
                System.out.println();
            }
        }
        
    }

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] m = new int[rows][cols];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                m[i][j] = (int)(Math.random() * 10);
        return m;
    }

    public static void displayMatrix(int[][] m) {
        for(int[] row : m) {
            for(int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static int[][] add(int[][] m1, int[][] m2) {
        int rows = m1.length;
        int cols = m1[0].length;
        int[][] res = new int[rows][cols];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                res[i][j] = m1[i][j] + m2[i][j];
        return res;
    }

    public static int[][] subtract(int[][] m1, int[][] m2) {
        int rows = m1.length;
        int cols = m1[0].length;
        int[][] res = new int[rows][cols];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                res[i][j] = m1[i][j] - m2[i][j];
        return res;
    }

    public static int[][] multiply(int[][] m1, int[][] m2) {
        int r1 = m1.length;
        int c1 = m1[0].length;
        int c2 = m2[0].length;
        int[][] res = new int[r1][c2];
        for(int i=0; i<r1; i++) {
            for(int j=0; j<c2; j++) {
                for(int k=0; k<c1; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static int[][] transpose(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int[][] res = new int[cols][rows];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                res[j][i] = m[i][j];
        return res;
    }

    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static int determinant3x3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1]) -
               m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0]) +
               m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) {
            System.out.println("Determinant is 0, inverse does not exist.");
            return null;
        }
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double)det;
        inv[0][1] = -m[0][1] / (double)det;
        inv[1][0] = -m[1][0] / (double)det;
        inv[1][1] = m[0][0] / (double)det;
        return inv;
    }

    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        // Cofactor expansion logic (simplified for brevity)
        // This requires calculating minors for each element
        // For full implementation, we need a minor method
        // Placeholder for brevity as 3x3 inverse is complex to write out fully without helper methods
        System.out.println("3x3 Inverse calculation requires full cofactor matrix implementation.");
        return null; 
    }
}