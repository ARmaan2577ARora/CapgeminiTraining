package Level1_30_01_2026;

class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        int peakIndex = findPeak(arr);
        System.out.println("Peak element index: " + peakIndex + " (Value: " + arr[peakIndex] + ")");
    }

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
