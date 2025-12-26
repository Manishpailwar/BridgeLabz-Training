import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        System.out.println("Enter ages for 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        System.out.println("\nVoting Eligibility:");
        for (int i = 0; i < 10; i++) {
            if (canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " (Age " + ages[i] + "): Can Vote");
            } else {
                System.out.println("Student " + (i + 1) + " (Age " + ages[i] + "): Cannot Vote");
            }
        }
        scanner.close();
    }

    public static boolean canStudentVote(int age) {
        return age >= 18;
    }
}