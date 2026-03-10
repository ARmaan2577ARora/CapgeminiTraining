class HamidDyslexic {
    public static void main(String[] args) {
        String s = "normalization";
        if(s.length() <= 10){
            System.out.println(s);
        }
        else System.out.print("" + (s.charAt(0)) + (s.length() - 2) + s.charAt(s.length()-1));
    }    
}
