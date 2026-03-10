class MidWithoutNegative {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,-4,5,6};
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (left < right) {
            if (arr[right] > 0) {
                mid = right;
            }
            if(arr[left] > 0){
                mid = left;
            }
            left++;
            right--;
        }
        System.out.println(arr[mid]);    
    }    
}
