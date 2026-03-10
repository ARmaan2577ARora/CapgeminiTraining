class PeakHike{
    public static int peak(int[] arr , int n){
        for(int i = 0;i < n-1;i++){
            if(arr[i] > arr[i+1]) return arr[i];
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,3,2,1};
        int n = 7;
        System.out.print(peak(arr,n));
    }
}