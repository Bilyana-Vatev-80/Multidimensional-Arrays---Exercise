import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        int count = 0;
        for (int row = 0; row < rows; row++) {
            List<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(count++);
            }
            matrix.add(numbers);
        }
        String command = "";
        while (!(command = scanner.nextLine()).equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
            int targetRow = tokens[0];
            int targetCol = tokens[1];
            int radius = tokens[2];

            for (int row = targetRow - radius; row < targetRow + radius; row++) {
                if (isValid(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }
            for (int col = targetCol - radius; col < targetCol + radius; col++) {
                if (isValid(matrix, col, targetRow)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                matrix.get(i).removeAll(List.of(0));

                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }
        }
        printMatrix(matrix, rows, cols);
    }

    private static void printMatrix(List<List<Integer>> matrix, int rows, int cols) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(List<List<Integer>> matrix, int row, int col) {
        return ((row > 0 && row < matrix.size()) && (col > 0 && col < matrix.get(row).size()));
    }

    private static void fillTheMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
