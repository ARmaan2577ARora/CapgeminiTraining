class PalindromeCount{
    public static void main(String[] args){
        String s = "this WOW is level 71";
        int count = 0;
        String[] words = s.split("\\s+");
        for(String word : words){
            int left = 0,right = word.length()-1;
            boolean isPal = true;
            while(left < right){
                if(word.charAt(left) != word.charAt(right)){
                    isPal = false;
                }
                left++;
                right--;
            }
            if(isPal) count++;
        }
        System.out.print(count);
    }
}