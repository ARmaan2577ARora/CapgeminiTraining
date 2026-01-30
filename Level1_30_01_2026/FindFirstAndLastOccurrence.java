package Level1_30_01_2026;

import java.util.Arrays;

class FindFirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = findRange(arr, target);
        System.out.println("First and Last occurrence of " + target + ": " + Arrays.toString(result));
    }

    public static int[] findRange(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        return new int[] { first, last };
    }

    private static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
