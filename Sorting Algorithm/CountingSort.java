public class CountingSort {
    public static void sort(int[] ages) {
        int n = ages.length;
        int min = 10;
        int max = 18;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }

        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] ages = { 15, 12, 18, 10, 15, 14, 11, 13, 17, 10 };
        System.out.println("Original Student Ages:");
        printArray(ages);

        sort(ages);

        System.out.println("Sorted Student Ages (Ascending Order):");
        printArray(ages);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
