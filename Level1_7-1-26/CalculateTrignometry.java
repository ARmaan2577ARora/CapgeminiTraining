import java.util.Scanner;

class CalculateTrignometry {
    public static double[] calculateTrignometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double[] results = new double[3];
        results[0] = Math.sin(angleInRadians);
        results[1] = Math.cos(angleInRadians);
        results[2] = Math.tan(angleInRadians);
        return results;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double angleInDegrees = scanner.nextDouble();
        double[] results = calculateTrignometricFunctions(angleInDegrees);
        System.out.println("Sine: " + results[0] + ", Cosine: " + results[1] + ", Tangent: " + results[2]);
        scanner.close();
    }    
}
