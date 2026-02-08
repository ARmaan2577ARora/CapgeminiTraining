package java8problem.level1folder;

import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public double getRiskScore() { return riskScore; }

    @Override
    public String toString() {
        return "RiskAssessment{holderId='" + holderId + "', name='" + name + "', riskScore=" + String.format("%.2f", riskScore) + "}";
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H001", "Emma", 65, "Life", 40.0),
            new PolicyHolder("H002", "Jack", 70, "Life", 30.0),
            new PolicyHolder("H003", "Liam", 55, "Life", 25.0),
            new PolicyHolder("H004", "Olivia", 62, "Health", 50.0),
            new PolicyHolder("H005", "Sophia", 68, "Life", 50.0),
            new PolicyHolder("H006", "Noah", 75, "Life", 20.0)
        );

        processRiskAssessment(holders);
    }

    public static void processRiskAssessment(List<PolicyHolder> holders) {
        // 1. Filter: policyType of "Life" and age > 60
        // 2. Transform: Create RiskAssessment objects (risk score = premiumAmount / age)
        // 3. Sort: Risk score descending
        List<RiskAssessment> sortedAssessments = holders.stream()
            .filter(h -> "Life".equals(h.getPolicyType()) && h.getAge() > 60)
            .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), (double) h.getPremiumAmount() / h.getAge()))
            .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
            .collect(Collectors.toList());

        System.out.println("Risk Assessments (Life > 60, Descending Score):");
        sortedAssessments.forEach(System.out::println);

        // 4. Categorize: Group by risk categories: "High Risk" (score > 0.5) and "Low Risk"
        Map<String, List<RiskAssessment>> categorizedRisk = sortedAssessments.stream()
            .collect(Collectors.groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println("\nRisk Categorization:");
        categorizedRisk.forEach((category, list) -> {
            System.out.println(category + ": " + list.stream().map(RiskAssessment::getName).collect(Collectors.joining(", ")));
        });
    }
}
