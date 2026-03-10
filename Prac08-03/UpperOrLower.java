class UpperOrLower {
    public static void main(String[] args) {
        String s = "HeLlO";
        int sumUpper = 0,sumLower = 0;
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sumUpper++;
            }
            else sumLower++;
        }
        System.out.print(sumLower > sumUpper ? s.toLowerCase() : s.toUpperCase());
    }    
}
