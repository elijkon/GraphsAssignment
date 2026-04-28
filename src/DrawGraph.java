public class DrawGraph {
    public static void printAdjacencyMatrix(String s) {
        int n = s.length();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int stepsRight = (2 * i) + 1;
            int stepsLeft = (2 * i) + 2;

            int rightIndex = (i + stepsRight) % n;
            int leftIndex = (i - stepsLeft) % n;
            while (leftIndex < 0) {
                leftIndex = leftIndex + n;
            }

            matrix[i][rightIndex] = 1;
            matrix[i][leftIndex] = 1;
        }

        System.out.println("adjacency matrix for: " + s);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printAdjacencyMatrix("ABCDE");
    }
}
