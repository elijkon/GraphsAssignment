public class EveryPath {
    private static void dfs(int[][] graph, int startNode, int currentNode, int depth, boolean[] visited, int[] path) {
        int n = graph.length;

        if (depth == 4) {
            if (graph[currentNode][startNode] != 0) {
                System.out.println("cycle found: " + path[0] + " -> " + path[1] + " -> " + path[2] + " -> " + path[3] + " -> " + startNode);
            }
            return;
        }

        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (graph[currentNode][neighbor] != 0 && visited[neighbor] == false) {

                visited[neighbor] = true;
                path[depth] = neighbor;
                dfs(graph, startNode, neighbor, depth + 1, visited, path);
                visited[neighbor] = false;
            }
        }
    }

    public static void findCyclesOfLength4(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] path = new int[4];

        for (int i = 0; i < n; i++) {

            visited[i] = true;
            path[0] = i;
            dfs(graph, i, i, 1, visited, path);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        int[][] graph1 = {
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println("testing graph 1 (should find 4 cycles):");
        findCyclesOfLength4(graph1);

        int[][] graph2 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println("testing graph 2 (should find nothing):");
        findCyclesOfLength4(graph2);
    }
}
