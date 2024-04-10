import java.util.*;

public class BFS_Practical {
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

        void BFS(int start) {
            boolean[] visited = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            while (queue.size() != 0) {
                start = queue.poll();
                System.out.print(start + " ");

                Iterator<Integer> i = adj[start].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
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

        System.out.print("Enter the starting node for BFS: ");
        int startNode = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        System.out.println("BFS traversal order:");
        graph.BFS(startNode);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("\nTime taken for BFS: " + elapsedTime + " milliseconds");

        scanner.close();
    }
}
