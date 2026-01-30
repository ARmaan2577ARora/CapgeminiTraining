package Level1_30_01_2026;

class SearchChallenge {
    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        int[] sortedArr = { 1, 3, 4, 8, 10 };
        int target = 4;
        int index = binarySearch(sortedArr, target);
        System.out.println("Index of " + target + " in sorted array: " + index);
    }

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
