class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "aaabbccdddd";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (result.contains(s.charAt(i) + "")) {
                continue;
            }
            result += s.charAt(i);
        }
        System.out.println(result);
    }
}