import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(", ");
        int size = Integer.parseInt(line[0]);
        String pattern = line[1];

        int[][] matrix = new int[size][size];

        int startNumber = 1;
        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            }
        } else if (pattern.equals("B")) {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    // even col to down
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = startNumber++;
                    }
                } else {
                    // odd col from down to up
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = startNumber++;
                    }
                }

            }
        }
        printMatrix(matrix, size, size);
    }

    public static void fillMatrixTape1(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void fillMatrixTape2(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
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
