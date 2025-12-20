import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks (Phy, Chem, Math) for student " + (i + 1) + ": ");
            int p = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks. Enter positive values.");
                i--; continue;
            }
            physics[i] = p; chemistry[i] = c; maths[i] = m;
            percentages[i] = (p + c + m) / 3.0;

            if (percentages[i] >= 90) grades[i] = "A+";
            else if (percentages[i] >= 80) grades[i] = "A";
            else if (percentages[i] >= 70) grades[i] = "B";
            else if (percentages[i] >= 60) grades[i] = "C";
            else grades[i] = "F";
            
            System.out.println("Student " + (i + 1) + ": " + percentages[i] + "% Grade: " + grades[i]);
        }
        sc.close();
    }
}