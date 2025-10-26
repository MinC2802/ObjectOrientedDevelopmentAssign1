package com.gadgetstore.utils;

import java.util.Scanner;

/**
 * Utility class for console input/output operations
 * Demonstrates Singleton-like pattern for Scanner
 */
public class ConsoleHelper {
    private static Scanner scanner;
    
    private ConsoleHelper() {
        // Private constructor
    }
    
    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
    
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
    
    public static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" " + title);
        System.out.println("=".repeat(50));
    }
    
    public static void printSection(String section) {
        System.out.println("\n" + "-".repeat(30));
        System.out.println(" " + section);
        System.out.println("-".repeat(30));
    }
    
    public static void pause() {
        System.out.println("\nPress Enter to continue...");
        getScanner().nextLine();
    }
    
    public static String readNonEmptyString(String prompt) {
        Scanner scanner = getScanner();
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }
    
    public static int readPositiveInt(String prompt) {
        Scanner scanner = getScanner();
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    public static double readPositiveDouble(String prompt) {
        Scanner scanner = getScanner();
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}