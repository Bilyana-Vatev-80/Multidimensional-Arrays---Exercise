import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrixTape1(scanner, matrix, matrixSize, matrixSize);
        int sumD1 = 0;
        int sumD2 = 0;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (row == col) {
                    sumD1 += matrix[row][col];
                }
                if (col == matrixSize - row - 1) {
                    sumD2 += matrix[row][col];
                }
            }
        }
        int difference = Math.abs(sumD1 - sumD2);
        System.out.println(difference);
    }

    public static void fillMatrixTape1(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
