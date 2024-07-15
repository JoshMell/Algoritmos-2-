
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array antes del ordenamiento:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nArray después del ordenamiento:");
        printArray(arr);
    }

    // Algoritmo de ordenamiento QuickSort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Obtener el índice del pivote
            int pi = partition(arr, low, high);

            // Ordenar los elementos antes y después del pivote
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Método para encontrar el pivote y particionar el array
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Tomar el último elemento como pivote
        int i = low - 1; // Índice del menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;

                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[high] (o el pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Método para imprimir el array
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

