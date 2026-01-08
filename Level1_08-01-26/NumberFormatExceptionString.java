public class NumberFormatExceptionString {
    public static void main(String[] args) {
        handleException();
    }
    public static void gernerateException(){
        String name = "armaan";
        int num = Integer.parseInt(name);
        System.out.println(num);
    }
    public static void handleException(){
        String name = "armaan";
        try{
            int num = Integer.parseInt(name);
            System.out.println(num);
        }
        catch(NumberFormatException e){
            System.out.println("NumberFormatException");
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
       }
    }
}