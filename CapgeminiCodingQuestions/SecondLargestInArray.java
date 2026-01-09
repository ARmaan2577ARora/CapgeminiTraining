import java.util.Scanner;

class SecondLargestInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] arr = new int[number];
        for(int i = 0; i < number; i++){
            arr[i] = sc.nextInt();
        }
        int largest = Integer.MIN_VALUE;
        int secondl = Integer.MIN_VALUE;
        for(int i = 0; i < number; i++){
            if(arr[i] > largest){
                secondl = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondl && arr[i] != largest){
                secondl = arr[i];
            }
        }
        System.out.println(secondl);
        sc.close();
    }    
}
