package java8problem.level1folder;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    LocalDate transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, LocalDate transactionDate,
            boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "POL1", 12000.0, LocalDate.now(), true),
                new Transaction("T002", "POL1", 15000.0, LocalDate.now(), true),
                new Transaction("T003", "POL1", 8000.0, LocalDate.now(), false),
                new Transaction("T004", "POL1", 11000.0, LocalDate.now(), true),
                new Transaction("T005", "POL1", 10000.0, LocalDate.now(), true),
                new Transaction("T006", "POL1", 13000.0, LocalDate.now(), true),
                new Transaction("T007", "POL1", 5000.0, LocalDate.now(), true), // 6th fraudulent
                new Transaction("T008", "POL2", 60000.0, LocalDate.now(), true), // Exceeds 50k
                new Transaction("T009", "POL3", 5000.0, LocalDate.now(), true),
                new Transaction("T010", "POL2", 2000.0, LocalDate.now(), true));

        processFraudDetection(transactions);
    }

    public static void processFraudDetection(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.toList());
                
        Map<String, List<Transaction>> fraudByPolicy = transactions.stream()
                .filter(Transaction::isFraudulent)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        System.out.println("Fraud Aggregation by Policy:");
        fraudByPolicy.forEach((policy, policyTransactions) -> {
            long count = policyTransactions.size();
            double totalAmount = policyTransactions.stream().mapToDouble(Transaction::getAmount).sum();
            System.out.println("Policy: " + policy + ", Count: " + count + ", Total Amount: " + totalAmount);
        });

        System.out.println("\n---- ALERTS ----");
        fraudByPolicy.forEach((policy, policyTransactions) -> {
            long count = policyTransactions.size();
            double totalAmount = policyTransactions.stream().mapToDouble(Transaction::getAmount).sum();
            if (count > 5 || totalAmount > 50000) {
                System.out.println("ALERT: Policy " + policy + " flagged! (Count: " + count + ", Total Fraud: "
                        + totalAmount + ")");
            }
        });
    }
}
