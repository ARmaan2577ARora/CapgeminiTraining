class CaesarCypher {
    public static void main(String[] args) {
        String s = "nrfzh";
        String res = "";
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 'd' && ch <= 'z'){
                res += (char)(ch - 3);
            }
            else res +=(char)(ch - 3 + 26);
        }
        System.out.println(res);
    }
}
