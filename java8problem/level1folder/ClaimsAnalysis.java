package java8problem.level1folder;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    LocalDate claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Claim{claimId='" + claimId + "', policyNumber='" + policyNumber + "', claimAmount=" + claimAmount
                + ", status='" + status + "'}";
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "POL123", 6000.0, LocalDate.now(), "Approved"),
                new Claim("C002", "POL123", 4000.0, LocalDate.now(), "Approved"),
                new Claim("C003", "POL456", 8000.0, LocalDate.now(), "Pending"),
                new Claim("C004", "POL456", 7000.0, LocalDate.now(), "Approved"),
                new Claim("C005", "POL789", 12000.0, LocalDate.now(), "Approved"),
                new Claim("C006", "POL789", 3000.0, LocalDate.now(), "Approved"),
                new Claim("C007", "POL101", 15000.0, LocalDate.now(), "Approved"));

        processClaims(claims);
    }

    public static void processClaims(List<Claim> claims) {
        // 1. Filter: Status "Approved" and amount > 5,000
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> "Approved".equals(c.getStatus()) && c.getClaimAmount() > 5000)
                .collect(Collectors.toList());

        // 2. Group: Group by policyNumber
        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        // 3. Aggregate: Total and average claimAmount for each policy
        System.out.println("Policy Aggregation (Approved > 5,000):");
        groupedByPolicy.forEach((policy, policyClaims) -> {
            double total = policyClaims.stream().mapToDouble(Claim::getClaimAmount).sum();
            double average = policyClaims.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0.0);
            System.out.println("Policy: " + policy + ", Total: " + total + ", Average: " + average);
        });

        // 4. Top N: Top 3 policies with the highest total claim amount
        System.out.println("\nTop 3 Policies by Total Claim Amount:");
        claims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber, Collectors.summingDouble(Claim::getClaimAmount)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out
                        .println("Policy: " + entry.getKey() + ", Total Amount: " + entry.getValue()));
    }
}
