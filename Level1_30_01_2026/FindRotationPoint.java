package Level1_30_01_2026;

class FindRotationPoint {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int rotationPointIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationPointIndex + " (Value: " + arr[rotationPointIndex] + ")");
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        if (arr[left] < arr[right])
            return 0; // Not rotated

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
