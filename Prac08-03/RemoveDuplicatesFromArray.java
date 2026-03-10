import java.util.HashSet;

class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] arr = {11,12,11,12,13,14,15};
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for(int num : set){
            result[i] = num;
            i++;
        }
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
 