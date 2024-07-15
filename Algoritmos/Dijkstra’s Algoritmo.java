// Java Implementation

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Dijkstra's algorithm for dense graphs
    static List<Integer> dijkstra(int n, List<List<Pair>> adj, int src) {
        // Array to store minimum distances
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        // Array to mark visited vertices
        boolean[] vis = new boolean[n + 1];

        // Set the distance to the source as 0
        dis[src] = 0;

        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (v == -1 || dis[j] < dis[v]))
                    v = j;
            }

            if (dis[v] == Integer.MAX_VALUE)
                break;
            // Mark vertex v as visited
            vis[v] = true;

            for (Pair edge : adj.get(v)) {
                // Neighbor vertex
                int x = edge.vertex;
                // Edge weight
                int wt = edge.weight;

                // Update the distance if a shorter path is found
                if (dis[v] + wt < dis[x]) {
                    dis[x] = dis[v] + wt;
                }
            }
        }
        // Return the array of minimum distances
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            result.add(dis[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // Number of vertices
        int n = 6;
        // Adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Example: adding edges to the adjacency list

        // Edge from vertex 1 to 2 with weight 3
        adj.get(1).add(new Pair(2, 3));
        // Edge from vertex 1 to 3 with weight 5
        adj.get(1).add(new Pair(3, 5));
        // Edge from vertex 2 to 3 with weight 1
        adj.get(2).add(new Pair(3, 1));
        // Edge from vertex 3 to 4 with weight 2
        adj.get(3).add(new Pair(4, 2));
        // Edge from vertex 2 to 4 with weight 7
        adj.get(2).add(new Pair(4, 7));

        int src = 1; // Source vertex

        List<Integer> distances = dijkstra(n, adj, src);

        // Print the minimum distances from the source to all other vertices
        for (int i = 1; i <= n; i++) {
            System.out.println("Minimum distance from vertex " + 
                               src + " to " + i + " is " + distances.get(i));
        }
    }

    static class Pair {
        int vertex;
        int weight;

        Pair(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
}
