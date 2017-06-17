package src;

/**
 * 快速排序，Get！
 */
public class QuickSortDemo{
    public static void quickort(int[] a, int left, int right) {
        if (right > left) {
            int pivotIndex = partition(a, left, right, right);
            quickort(a, left, pivotIndex - 1);
            quickort(a, pivotIndex + 1, right);
        }
    }
    private static int partition(int[] a, int left, int right, int pivotIndex) {
        swap(a, right, pivotIndex);
        pivotIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] <= a[right]) {
                swap(a, pivotIndex++, i);
            }
        }
        swap(a, right, pivotIndex);
        return pivotIndex;
    }
    private static void swap(int[] a, int i, int j) {
        a[i] = a[j] ^ a[i] ^ (a[j] = a[i]);
    }
    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickort(a, 0, a.length - 1);
        System.out.println("--------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

