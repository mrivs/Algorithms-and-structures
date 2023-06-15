// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

package homework02;

import java.util.Arrays;

public class task01 {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 4, 3, 7, 9, 4, 6, 2, 6, 3, 3, 4, 7, 8, 1, 7, 3, 5, 8, 6, 4 };
        Heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Heapsort(int arr[]) {
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--) // Построение кучи (перегруппируем массив)
            heapify(arr, len, i);

        for (int i = len - 1; i >= 0; i--) // Один за другим извлекаем элементы из кучи
        {

            int temp = arr[0]; // Перемещаем текущий корень в конец
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // левый элемент = 2*i + 1
        int right = 2 * i + 2; // правый элемент = 2*i + 2

        if (left < n && arr[left] > arr[largest]) // Если левый дочерний элемент больше корня
            largest = left;

        if (right < n && arr[right] > arr[largest])// Если правый дочерний элемент больше, чем самый большой элемент на
                                                   // данный момент

            largest = right;

        if (largest != i) { // Если самый большой элемент не корень
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}