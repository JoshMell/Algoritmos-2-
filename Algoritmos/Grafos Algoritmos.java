import java.util.*;

// Clase para representar un grafo no dirigido mediante listas de adyacencia
class Grafo {
    private int V; // Número de vértices
    private LinkedList<Integer> adj[]; // Lista de adyacencia

    // Constructor
    Grafo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Método para agregar una arista al grafo
    void agregarArista(int v, int w) {
        adj[v].add(w); // Añadir w a la lista de v
        adj[w].add(v); // Añadir v a la lista de w
    }

    // Método para realizar un recorrido en profundidad (DFS) desde un vértice
    void DFS(int v, boolean visitado[]) {
        // Marcar el vértice actual como visitado
        visitado[v] = true;
        System.out.print(v + " ");

        // Recorrer todos los vértices adyacentes al vértice v
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visitado[n])
                DFS(n, visitado); // Si el vértice no ha sido visitado, hacer DFS recursivamente
        }
    }

    // Método para realizar un recorrido en profundidad (DFS) desde un vértice dado
    // Es útil para grafos desconectados
    void DFSUtil(int v, boolean visitado[]) {
        // Marcar todos los vértices como no visitados
        for (int i = 0; i < V; ++i)
            visitado[i] = false;

        // Llamar al método auxiliar DFS recursivo
        DFS(v, visitado);
    }

    public static void main(String args[]) {
        Grafo g = new Grafo(5); // Crear un grafo con 5 vértices

        // Agregar las aristas del grafo
        g.agregarArista(0, 1);
        g.agregarArista(0, 4);
        g.agregarArista(1, 2);
        g.agregarArista(1, 3);
        g.agregarArista(1, 4);
        g.agregarArista(2, 3);
        g.agregarArista(3, 4);

        System.out.println("Recorrido en profundidad (DFS) desde el vértice 0:");
        boolean visitado[] = new boolean[5];
        g.DFSUtil(0, visitado);
    }
}
