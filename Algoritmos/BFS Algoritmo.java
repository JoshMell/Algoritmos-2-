import java.util.*;

public class BFSExample {
    private int V; // Número de vértices
    private LinkedList<Integer> adj[]; // Lista de adyacencia
    
    // Constructor
    BFSExample(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    
    // Método para agregar una arista al grafo
    void agregarArista(int v, int w) {
        adj[v].add(w); // Añadir w a la lista de v
    }
    
    // Método para realizar un recorrido BFS desde un vértice
    void BFS(int s) {
        // Arreglo para marcar los vértices como visitados
        boolean visitado[] = new boolean[V];
        
        // Cola para el BFS
        LinkedList<Integer> cola = new LinkedList<>();
        
        // Marcar el vértice actual como visitado y encolarlo
        visitado[s] = true;
        cola.add(s);
        
        while (!cola.isEmpty()) {
            // Desencolar un vértice de la cola y mostrarlo
            s = cola.poll();
            System.out.print(s + " ");
            
            // Obtener todos los vértices adyacentes del vértice desencolado
            Iterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                // Si el vértice no ha sido visitado, marcarlo como visitado y encolarlo
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                }
            }
        }
    }
    
    // Método principal
    public static void main(String args[]) {
        BFSExample g = new BFSExample(4); // Crear un grafo con 4 vértices
        
        // Agregar las aristas del grafo
        g.agregarArista(0, 1);
        g.agregarArista(0, 2);
        g.agregarArista(1, 2);
        g.agregarArista(2, 0);
        g.agregarArista(2, 3);
        g.agregarArista(3, 3);
        
        System.out.println("Recorrido BFS comenzando desde el vértice 2:");
        g.BFS(2);
    }
}
