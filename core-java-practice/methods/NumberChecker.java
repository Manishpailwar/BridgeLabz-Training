import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int number = scanner.nextInt();

        int[] digits = getDigits(number);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Count of digits: " + countDigits(number));
        System.out.println("Sum of digits: " + sumDigits(digits));
        System.out.println("Sum of squares of digits: " + sumSquaresDigits(digits));
        
        System.out.println("Is Duck Number: " + isDuckNumber(number));
        System.out.println("Is Armstrong Number: " + isArmstrong(number));
        System.out.println("Is Harshad Number: " + isHarshad(number));
        System.out.println("Is Palindrome: " + isPalindrome(number));
        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeon(number));
        System.out.println("Is Spy: " + isSpy(number));
        System.out.println("Is Automorphic: " + isAutomorphic(number));
        System.out.println("Is Buzz: " + isBuzz(number));
        System.out.println("Is Perfect: " + isPerfect(number));
        System.out.println("Is Abundant: " + isAbundant(number));
        System.out.println("Is Deficient: " + isDeficient(number));
        System.out.println("Is Strong: " + isStrong(number));

        int[] largestTwo = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestTwo[0] + ", Second Largest: " + largestTwo[1]);

        int[] smallestTwo = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestTwo[0] + ", Second Smallest: " + smallestTwo[1]);

        System.out.println("Digit Frequencies:");
        int[][] freqs = getDigitFrequency(number);
        for (int[] row : freqs) {
            if (row[1] > 0) System.out.println("Digit " + row[0] + ": " + row[1]);
        }
        scanner.close();
    }

    // --- Basic Digit Operations ---
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigits(int number) {
        String s = String.valueOf(Math.abs(number));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        return digits;
    }

    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static double sumSquaresDigits(int[] digits) {
        double sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    // --- Array Analysis ---
    public static int[] findLargestAndSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > max) {
                secondMax = max;
                max = n;
            } else if (n > secondMax && n != max) {
                secondMax = n;
            }
        }
        return new int[]{max, secondMax};
    }

    public static int[] findSmallestAndSecondSmallest(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n < min) {
                secondMin = min;
                min = n;
            } else if (n < secondMin && n != min) {
                secondMin = n;
            }
        }
        return new int[]{min, secondMin};
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static int[][] getDigitFrequency(int number) {
        int[] digits = getDigits(number);
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    // --- Number Properties ---
    public static boolean isDuckNumber(int number) {
        // Standard definition: Contains a zero (but doesn't start with it, which int doesn't anyway)
        String s = String.valueOf(number);
        return s.contains("0");
    }

    public static boolean isArmstrong(int number) {
        int[] digits = getDigits(number);
        int len = digits.length;
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, len);
        return sum == number;
    }

    public static boolean isHarshad(int number) {
        int sum = sumDigits(getDigits(number));
        return number % sum == 0;
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigits(number);
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        return sumDigits(getDigits(square)) == number;
    }

    public static boolean isSpy(int number) {
        int[] digits = getDigits(number);
        int sum = 0;
        int product = 1;
        for (int d : digits) {
            sum += d;
            product *= d;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        String numStr = String.valueOf(number);
        String sqStr = String.valueOf((long)number * number);
        return sqStr.endsWith(numStr);
    }

    public static boolean isBuzz(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum == number;
    }

    public static boolean isAbundant(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum > number;
    }

    public static boolean isDeficient(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum < number;
    }

    public static boolean isStrong(int number) {
        int[] digits = getDigits(number);
        int sum = 0;
        for (int d : digits) {
            sum += factorial(d);
        }
        return sum == number;
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }
}