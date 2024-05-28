import java.util.Scanner;

public class Main {

    static final int GRID_SIZE = 20;
    static int[][] grid = new int[GRID_SIZE][GRID_SIZE];

    public static int calculateMaxProduct(int x, int y) {
        int maxProduct = 0;
        int horizontalProduct = 1, verticalProduct = 1, diagonalProduct1 = 1, diagonalProduct2 = 1;

        // Horizontal product
        if (y + 3 < GRID_SIZE) {
            for (int i = 0; i < 4; i++) {
                horizontalProduct *= grid[x][y + i];
            }
            maxProduct = Math.max(maxProduct, horizontalProduct);
        }

        // Vertical product
        if (x + 3 < GRID_SIZE) {
            for (int i = 0; i < 4; i++) {
                verticalProduct *= grid[x + i][y];
            }
            maxProduct = Math.max(maxProduct, verticalProduct);
        }

        // Diagonal product (down-right)
        if (x + 3 < GRID_SIZE && y + 3 < GRID_SIZE) {
            for (int i = 0; i < 4; i++) {
                diagonalProduct1 *= grid[x + i][y + i];
            }
            maxProduct = Math.max(maxProduct, diagonalProduct1);
        }

        // Diagonal product (down-left)
        if (x + 3 < GRID_SIZE && y - 3 >= 0) {
            for (int i = 0; i < 4; i++) {
                diagonalProduct2 *= grid[x + i][y - i];
            }
            maxProduct = Math.max(maxProduct, diagonalProduct2);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input grid values
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int maxProduct = 0;
        // Calculate max product
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                maxProduct = Math.max(maxProduct, calculateMaxProduct(i, j));
            }
        }

        System.out.println(maxProduct);
        scanner.close();
    }
}
