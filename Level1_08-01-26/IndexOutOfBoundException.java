public class IndexOutOfBoundException {
    public static void main(String[] args) {
        handleException();
    }
    static void generateException(String str){
        String name = "armaan";
        for(int i=0;i<=str.length();i++){
            System.out.println(name.charAt(i));
        }
    }   
    static void handleException(){
        String name = "armaan";
        try{
            System.out.println(name.charAt(6));
        }
        catch(Exception e){
            System.out.println("StringIndexOutOfBoundsException");
        }
    }
}
