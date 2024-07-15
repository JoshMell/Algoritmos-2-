 import java.util.*;

public class DFSExample {
    private int V; // Número de vértices
    private LinkedList<Integer> adj[]; // Lista de adyacencia
    
    // Constructor
    DFSExample(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    
    // Método para agregar una arista al grafo
    void agregarArista(int v, int w) {
        adj[v].add(w); // Añadir w a la lista de v
    }
    
    // Método para realizar un recorrido DFS desde un vértice
    void DFS(int v, boolean visitado[]) {
        // Marcar el vértice actual como visitado y mostrarlo
        visitado[v] = true;
        System.out.print(v + " ");
        
        // Recorrer todos los vértices adyacentes al vértice v
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            // Si el vértice no ha sido visitado, hacer DFS recursivamente
            if (!visitado[n])
                DFS(n, visitado);
        }
    }
    
    // Método para inicializar el recorrido DFS desde un vértice dado
    void DFSUtil(int v) {
        // Arreglo para marcar los vértices como visitados
        boolean visitado[] = new boolean[V];
        
        // Llamar al método auxiliar DFS recursivo
        DFS(v, visitado);
    }
    
    // Método principal
    public static void main(String args[]) {
        DFSExample g = new DFSExample(4); // Crear un grafo con 4 vértices
        
        // Agregar las aristas del grafo
        g.agregarArista(0, 1);
        g.agregarArista(0, 2);
        g.agregarArista(1, 2);
        g.agregarArista(2, 0);
        g.agregarArista(2, 3);
        g.agregarArista(3, 3);
        
        System.out.println("Recorrido DFS comenzando desde el vértice 2:");
        g.DFSUtil(2);
    }
}
