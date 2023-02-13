import java.util.Random;
import java.util.Scanner;

public class SortingComparison {

        public static int[] createRandomArray(int arrayLength) {
            int length = arrayLength;
            Random random = new Random();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = random.nextInt(100);
            }
            return array;
        }

        public static void bubbleSort(int[] array) {
            for (int i = array.length - 1; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }
    
    public static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                k ++;
                i ++;
            } else {
                c[k] = b[j];
                k ++;
                j ++;
            }
        }

        while (i < a.length) {
                c[k] = a[i];
                k ++;
                i ++;
        }

        while (j < b.length) {
            c[k] = b[j];
            k ++;
            j ++;
        }

        return c;
    }

    public static void mergeArray(int[] a, int start, int middle, int end) {
        int[] c = new int[end - start];
        int i = start, j = middle, k = 0;

        while (i < middle && j < end) {
            if (a[i] <= a[j]) {
                c[k] = a[i];
                k ++;
                i ++;
            } else {
                c[k] = a[j];
                k ++;
                j ++;
            }
        }

        while (i < middle) {
            c[k] = a[i];
            k ++;
            i ++;
        }

        while (j < end) {
            c[k] = a[j];
            k ++;
            j ++;
        }

        for (i = start; i < end; i ++) {
            a[i] = c[i - start];
        }
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program will compare Bubble Sort and Merge Sort by using a random array of user-inputted length.");
        System.out.println("Please input the array length:");
        int arrayLength = scanner.nextInt();
        int[] array = createRandomArray(arrayLength);
        long start_time, time_spent;
        start_time = System.currentTimeMillis();
        bubbleSort(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Bubble sort time: " + time_spent + " ms");
        start_time = System.currentTimeMillis();
        mergeSort(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Merge sort time: " + time_spent + " ms");
        scanner.close();
    }
}