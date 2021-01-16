import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimension[0];
        int cols = dimension[1];

        String[][] matrix = new String[rows][cols];

        fillTheMatrix(scanner, matrix, rows, cols);
        String line = "";
        while (!(line = scanner.nextLine()).equals("END")) {
            String[] tokens = line.split("\\s+");

            if (!tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }
            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (row1 < 0 || row1 > matrix.length || col1 < 0 || col1 >= matrix.length
                    || row2 < 0 || row2 > matrix.length || col2 < 0 || col2 >= matrix.length) {
                System.out.println("Invalid input!");
                continue;
            }
            String tem = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tem;

            printMatrix(matrix, rows, cols);
        }
    }

    private static void fillTheMatrix(Scanner scanner, String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
