public class MergeSort {
    public static void sort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(prices, left, mid);
            sort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = prices[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = prices[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        double[] prices = {499.99, 150.50, 899.00, 250.75, 50.25, 1200.00};
        System.out.println("Original Book Prices:");
        printArray(prices);

        sort(prices, 0, prices.length - 1);

        System.out.println("Sorted Book Prices (Ascending Order):");
        printArray(prices);
    }

    private static void printArray(double[] arr) {
        for (double value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
