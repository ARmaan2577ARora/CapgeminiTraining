package Level2_07_01_26;

import java.util.Scanner;

public class SumOfNNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) return;

        int sum1 = 0;
        for (int i = 1; i <= n; i++)
            sum1 += i;

        int sum2 = n * (n + 1) / 2;

        System.out.println(sum1);
        System.out.println(sum2);
    }
}

//Problem 2

//Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct.
//        Hint =>
//Take the user input number and check whether it's a Natural number, if not exit
//Write a Method to find the sum of n natural numbers using recursion
//Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2
//Compare the two results and print the result
