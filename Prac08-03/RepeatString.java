class RepeatString{
    public static String stringRepeat(String s,int n){
        String res = "";
        for(int i = 0;i < n;i++){
            res += s;
        }
        return res;
    }
    public static void main(String[] args){
        String s = "abc";
        int n = 3;
        System.out.print(stringRepeat(s,n));
    }
}