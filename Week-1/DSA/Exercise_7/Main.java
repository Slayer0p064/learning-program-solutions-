package DSA.Exercise_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Financial Forecast ---");
        System.out.print("Initial Amount : ");
        double initial = sc.nextDouble();

        System.out.print("Growth Rate (%): ");
        double rate = sc.nextDouble();

        System.out.print("Years: ");
        int years = sc.nextInt();

        double resultRec = forecastRecursive(initial, rate, years);
        double resultItr = forecastIterative(initial, rate, years);

        System.out.printf("Recursive Future Value: %.2f%n", resultRec);
        System.out.printf("Iterative Future Value: %.2f%n", resultItr);

        sc.close();
    }

    public static double forecastRecursive(double amount, double rate, int years) {
        if (years == 0) return amount;
        return forecastRecursive(amount * (1 + rate / 100), rate, years - 1);
    }

    public static double forecastIterative(double amount, double rate, int years) {
        for (int i = 0; i < years; i++) {
            amount *= (1 + rate / 100);
        }
        return amount;
    }
}
