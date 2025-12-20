import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input for each friend
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age and height for " + names[i] + ": ");
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        int minAge = ages[0];
        double maxHeight = heights[0];
        String youngest = names[0];
        String tallest = names[0];

        // Find youngest and tallest
        for (int i = 1; i < 3; i++) {
            if (ages[i] < minAge) { minAge = ages[i]; youngest = names[i]; }
            if (heights[i] > maxHeight) { maxHeight = heights[i]; tallest = names[i]; }
        }

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);
        sc.close();
    }
}