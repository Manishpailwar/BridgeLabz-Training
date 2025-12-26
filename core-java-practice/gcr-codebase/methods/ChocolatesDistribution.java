import java.util.Scanner;

public class ChocolatesDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = scanner.nextInt();
        System.out.print("Enter number of children: ");
        int children = scanner.nextInt();
        
        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
        scanner.close();
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }
}