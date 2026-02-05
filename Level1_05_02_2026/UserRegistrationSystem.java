package Level1_05_02_2026;

// Custom Exception class
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class UserRegistrationSystem {
    public static void main(String[] args) {
        try {
            System.out.println("Registering user with age 15...");
            registerUser("Alice", 15);
        } catch (ValidationException e) {
            System.err.println("Registration Failed: " + e.getMessage());
        }

        try {
            System.out.println("\nRegistering user with age 20...");
            registerUser("Bob", 20);
        } catch (ValidationException e) {
            System.err.println("Registration Failed: " + e.getMessage());
        }
    }

    // Method using 'throws' to declare it might throw a checked exception
    public static void registerUser(String name, int age) throws ValidationException {
        if (age < 18) {
            // Using 'throw' to explicitly throw an exception
            throw new ValidationException("User must be at least 18 years old. Provided age: " + age);
        }
        System.out.println("User " + name + " registered successfully!");
    }
}
