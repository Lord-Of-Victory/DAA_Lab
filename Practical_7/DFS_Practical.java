import java.util.*;

public class DFS_Practical {
    static class Graph {
        private int V;
        private LinkedList<Integer>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSUtil(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        void DFS(int v) {
            boolean[] visited = new boolean[V];
            DFSUtil(v, visited);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        System.out.print("Enter the number of edges in the graph: ");
        int E = scanner.nextInt();
        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        System.out.print("Enter the starting node for DFS: ");
        int startNode = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        System.out.println("DFS traversal order:");
        graph.DFS(startNode);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("\nTime taken for DFS: " + elapsedTime + " milliseconds");

        scanner.close();
    }
}