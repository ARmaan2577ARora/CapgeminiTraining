package java8problem.level2folder;

import java.util.*;
import java.util.stream.Collectors;

class Policy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public Policy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "No='" + policyNumber + '\'' +
                ", Holder='" + holderName + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("POL001", "Alice Smith", 1500.0),
                new Policy("POL002", "Bob Johnson", 800.0),
                new Policy("POL003", "Charlie Williams", 2500.0),
                new Policy("POL004", "David Brown", 1200.0),
                new Policy("POL005", "Emma Smith", 1800.0),
                new Policy("POL006", "Frank Miller", 3000.0),
                new Policy("POL007", "Grace Davis", 950.0),
                new Policy("POL008", "Henry Wilson", 1100.0));

        processInsurancePolicies(policies);
    }

    public static void processInsurancePolicies(List<Policy> policies) {
        System.out.println("Processing Insurance Policies:\n");

        // 1. Filter Policies by Premium Amount > 1200
        List<Policy> premiumGT1200 = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());
        System.out.println("1. Policies with Premium > $1200: " + premiumGT1200);

        // 2. Sort Policies by Holder Name
        List<Policy> sortedByName = policies.stream()
                .sorted(Comparator.comparing(Policy::getHolderName))
                .collect(Collectors.toList());
        System.out.println("\n2. Policies sorted by Holder Name: " + sortedByName);

        // 3. Compute Total Premium
        double totalPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();
        System.out.println("\n3. Total Premium Amount: $" + totalPremium);

        // 4. Print Policy Details (Formatted)
        System.out.println("\n4. Policy Details:");
        policies.forEach(p -> System.out.printf("   - %s (%s): $%.2f%n", p.getHolderName(), p.getPolicyNumber(),
                p.getPremiumAmount()));

        // 5. Filter Policies by Premium Range (1000 - 2000)
        List<Policy> range1000_2000 = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());
        System.out.println("\n5. Policies with Premium between $1000 and $2000: " + range1000_2000);

        // 6. Find Policy with Highest Premium
        Policy highestPremium = policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount))
                .orElse(null);
        System.out.println("\n6. Policy with Highest Premium: " + highestPremium);

        // 7. Group Policies by Holder Name Initial
        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
        System.out.println("\n7. Policies grouped by Initial Letter: " + groupedByInitial);

        // 8. Compute Average Premium
        double avgPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .average()
                .orElse(0.0);
        System.out.println("\n8. Average Premium Amount: $" + avgPremium);

        // 9. Sort Policies by Premium and Print
        System.out.println("\n9. Policies sorted by Premium:");
        policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .forEach(System.out::println);

        // 10. Check If Any Policy Exceeds 2000
        boolean anyAbove2000 = policies.stream().anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("\n10. Any Policy > $2000? " + anyAbove2000);

        // 11. Count Policies for Each Premium Range
        Map<String, Long> rangeCounts = policies.stream().collect(Collectors.groupingBy(p -> {
            if (p.getPremiumAmount() <= 1000)
                return "$0-$1000";
            else if (p.getPremiumAmount() <= 2000)
                return "$1001-$2000";
            else
                return ">$2000";
        }, Collectors.counting()));
        System.out.println("\n11. Count per Premium Range: " + rangeCounts);

        // 12. Extract Unique Holder Names
        List<String> uniqueNames = policies.stream()
                .map(Policy::getHolderName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\n12. Unique Holder Names: " + uniqueNames);

        // 13. Find Policies by Holder Name Substring (e.g. "Smith")
        String searchStr = "Smith";
        List<Policy> smithHolders = policies.stream()
                .filter(p -> p.getHolderName().contains(searchStr))
                .collect(Collectors.toList());
        System.out.println("\n13. Policies with name containing '" + searchStr + "': " + smithHolders);

        // 14. Create a Map of Policy Numbers to Premium Amounts
        Map<String, Double> policyNumToPremium = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));
        System.out.println("\n14. Map of Policy Numbers to Premiums: " + policyNumToPremium);
    }
}
