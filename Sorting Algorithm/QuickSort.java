public class QuickSort {
    public static void sort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            sort(prices, low, pi - 1);
            sort(prices, pi + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        double[] prices = { 120.0, 45.5, 300.75, 15.2, 500.0, 25.4 };
        System.out.println("Original Product Prices:");
        printArray(prices);

        sort(prices, 0, prices.length - 1);

        System.out.println("Sorted Product Prices (Ascending Order):");
        printArray(prices);
    }

    private static void printArray(double[] arr) {
        for (double value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
