class MaxOccurChar{
    public static char maxOccur(String s){
        int[] freq = new int[26];
        for(int i = 0;i < s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }
        int max = 0;int idx = 0;
        for(int i = 0;i<freq.length;i++){
            if(max < freq[i]) {
                max = freq[i];
                idx = i;
            }
        }
        for(int i = 0;i < freq.length;i++){
            if(max == freq[i] && idx != i){
                return '0';
            }
        }
        return (char)(idx + 'a');
    }
    public static void main(String[] args){
        String str = "abcdd";
        System.out.print(maxOccur(str));
    }
}