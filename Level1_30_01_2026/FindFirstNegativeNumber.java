package Level1_30_01_2026;

class FindFirstNegativeNumber {
    public static void main(String[] args) {
        int[] arr = { 12, 5, -3, 8, -10, 7 };
        int index = findFirstNegative(arr);
        if (index != -1) {
            System.out.println("First negative number found at index: " + index + " (Value: " + arr[index] + ")");
        } else {
            System.out.println("No negative number found.");
        }
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
