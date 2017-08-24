public class BubberSort {
    public static void Bubbersort(int[] arr, int size) {
        if (size == 1) return;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        Bubbersort(arr, --size);
    }

    public static void main(String args[]) {
        int a[] = {1, 5, 4, 6, 8, 7, 9, 2, 3};
        Bubbersort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
