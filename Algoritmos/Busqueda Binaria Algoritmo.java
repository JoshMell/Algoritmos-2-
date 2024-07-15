import java.util.Scanner;

public class Main {

    // Método iterativo de búsqueda binaria
    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Si el elemento está presente en el medio
            if (arr[mid] == x)
                return mid;

            // Si el elemento es mayor, ignora la mitad izquierda
            if (arr[mid] < x)
                low = mid + 1;
            // Si el elemento es menor, ignora la mitad derecha
            else
                high = mid - 1;
        }

        // Si no se encuentra el elemento
        return -1;
    }

    // Método principal para ejecutar el programa
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Main ob = new Main();

        // Ejemplo de arreglo ordenado
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;

        // Elemento a buscar
        System.out.print("Ingrese el número a buscar: ");
        int x = scanner.nextInt();

        // Ejecutar búsqueda binaria
        int result = ob.binarySearch(arr, x);

        // Imprimir resultado
        if (result == -1)
            System.out.println("Elemento no encontrado en el arreglo.");
        else
            System.out.println("Elemento encontrado en el índice " + result);

        scanner.close();
    }
}
