package Level1_30_01_2026;
class RevStringUsingBuilder {
    public static void main(String[] args) {
        String str = "hello";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}