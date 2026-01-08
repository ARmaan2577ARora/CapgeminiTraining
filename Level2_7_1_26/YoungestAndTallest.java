package Level2_07_01_26;

import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int youngest = age[0];
        double tallest = height[0];

        for (int i = 1; i < 3; i++) {
            if (age[i] < youngest) youngest = age[i];
            if (height[i] > tallest) tallest = height[i];
        }

        System.out.println("Youngest Age = " + youngest);
        System.out.println("Tallest Height = " + tallest);
    }
}

//Problem 8

//Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it
//Hint =>
//Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends
//Write a Method to find the youngest of the 3 friends
//Write a Method to find the tallest of the 3 friends
