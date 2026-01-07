package Level2_07_01_26;

import java.util.Scanner;

import java.util.Scanner;

public class Random4DigitNumbers {

    public int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000); // 1000 to 9999
        }
        return arr;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }

        double average = (double) sum / numbers.length;

        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        Random4DigitNumbers obj = new Random4DigitNumbers();

        //  random 4-digit numbers
        int[] randomNumbers = obj.generate4DigitRandomArray(5);

        System.out.println("Generated 4-digit numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }


        double[] results = obj.findAverageMinMax(randomNumbers);

        System.out.println("Average = " + results[0]);
        System.out.println("Minimum = " + results[1]);
        System.out.println("Maximum = " + results[2]);
    }
}


//Problem 12

//Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
//Hint =>
//Write a method that generates array of 4 digit random numbers given the size as a parameter as shown in the method signature
//public int[] generate4DigitRandomArray(int size)
//Write a method to find average, min and max value of an array
//public double[] findAverageMinMax(int[] numbers)
