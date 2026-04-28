public class DirOrUndir {
    public static boolean isWeaklyConnected(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return true;
        }

        int[][] undirectedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]== 1 || matrix[j][i] == 1) {
                    undirectedMatrix[i][j] = 1;
                    undirectedMatrix[j][i] = 1;
                }
            }
        }
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int head = 0;
        int tail = 0;
        visited[0] = true;
        queue[tail] = 0;
        tail++;

        while (head < tail) {

            int currentNode = queue[head];
            head++;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (undirectedMatrix[currentNode][neighbor] == 1 && visited[neighbor]== false) {

                    visited[neighbor] = true;
                    queue[tail] = neighbor;
                    tail++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        int[][] graph2 = {
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        System.out.println("Is graph 1 weakly connected " + isWeaklyConnected(graph1));
        System.out.println("Is graph 2 weakly connected " + isWeaklyConnected(graph2));
    }
}
