public class IllegalArgumentExceptionString {
    public static void main(String[] args) {
        handleException();
    }
    static void generateException(){
        String s = "Armaan";
        System.out.println(s.substring(5,3));
    }
    static void handleException(){
        String s = "Armaan";
        try{
            System.out.println(s.substring(5,3));
        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException handled");
        }
        catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
}
