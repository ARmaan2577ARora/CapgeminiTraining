class EncodedString{
    public static void main(String[] args){
        String str = "111011110111111";
        int ones = 0;
        String res = "";
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '1') ones++;
            else {
                res += (char)(ones + 'A' -1);
                ones = 0;
            }
        }
        if(str.charAt(str.length()-1) == '1'){
            res += (char)(ones + 'A' -1);
        }
        System.out.print(res.toString());
    }
}