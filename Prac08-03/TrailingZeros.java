class TrailingZeros {
    public static void main(String[] args) {
        int[] arr = {5,0,6,7,0};
        int[] temp = new int[arr.length];
        int j = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != 0){
                temp[j] = arr[i];
                j++;
            }
        }
        for(int i = 0;i < temp.length;i++){
            System.out.print(temp[i] + " ");
        }
    }    
}
