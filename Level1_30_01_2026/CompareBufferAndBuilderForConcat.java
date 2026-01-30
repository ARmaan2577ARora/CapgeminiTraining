package Level1_30_01_2026;

class CompareBufferAndBuilderForConcat {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String s = "hello";
        StringBuffer sbf = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append(s);
        }
        long end  = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (end - start));
        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append(s);
        }
        end = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (end - start));        
    }    
}
