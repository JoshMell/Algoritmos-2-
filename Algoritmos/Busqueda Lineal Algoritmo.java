import java.util.Scanner;

public class Main {

    // Método de búsqueda lineal
    public static int search(int arr[], int N, int x) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Método principal para ejecutar el programa
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de arreglo y elemento a buscar
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        // Llamada a la función de búsqueda
        int result = search(arr, arr.length, x);

        // Imprimir resultado
        if (result == -1)
            System.out.println("Elemento no encontrado en el arreglo.");
        else
            System.out.println("Elemento encontrado en el índice " + result);

        scanner.close();
    }
}
