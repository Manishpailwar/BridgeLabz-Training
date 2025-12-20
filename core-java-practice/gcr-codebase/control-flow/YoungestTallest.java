import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Amar
        System.out.println("Enter age and height for Amar:");
        int ageAmar = sc.nextInt();
        double heightAmar = sc.nextDouble();

        // Akbar
        System.out.println("Enter age and height for Akbar:");
        int ageAkbar = sc.nextInt();
        double heightAkbar = sc.nextDouble();

        // Anthony
        System.out.println("Enter age and height for Anthony:");
        int ageAnthony = sc.nextInt();
        double heightAnthony = sc.nextDouble();

        // Find Youngest (Smallest Age)
        int minAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        System.out.print("Youngest friend(s): ");
        if (ageAmar == minAge) System.out.print("Amar ");
        if (ageAkbar == minAge) System.out.print("Akbar ");
        if (ageAnthony == minAge) System.out.print("Anthony ");
        System.out.println();

        // Find Tallest (Largest Height)
        double maxHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        System.out.print("Tallest friend(s): ");
        if (heightAmar == maxHeight) System.out.print("Amar ");
        if (heightAkbar == maxHeight) System.out.print("Akbar ");
        if (heightAnthony == maxHeight) System.out.print("Anthony ");
        System.out.println();

        sc.close();
    }
}