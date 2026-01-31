public class InsertionSort {
    public static void sort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {105, 102, 108, 101, 104, 103};
        System.out.println("Original Employee IDs:");
        printArray(employeeIds);

        sort(employeeIds);

        System.out.println("Sorted Employee IDs (Ascending Order):");
        printArray(employeeIds);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
