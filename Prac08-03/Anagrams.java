class Anagrams{
    public static void main(String[] args){
        String a = "abcd";
        String b = "dbca";
        int[] freq = new int[26];
        for(int i = 0;i < a.length();i++){
            freq[a.charAt(i)-'a']++;
            freq[b.charAt(i)-'a']--;
        }
        boolean is = true;
        for(int i = 0;i < freq.length;i++){
            if(freq[i] != 0){
                is = false;
            }
        }
        System.out.print(is?"yes":"no");
    }
}