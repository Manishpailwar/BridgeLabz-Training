import java.util.*;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for Physics:");
        int physics = sc.nextInt();
        System.out.println("Enter marks for Chemistry:");
        int chemistry = sc.nextInt();
        System.out.println("Enter marks for Maths:");
        int maths = sc.nextInt();
        if (physics >= 0 && physics <= 100 && chemistry >= 0 && chemistry <= 100 && maths >= 0 && maths <= 100) {
            double total = physics + chemistry + maths;
            double percentage = total / 3; 
            String grade;
            String remark;
            if (percentage >= 80) {
                grade = "A";
                remark = "Level 4, above agency-normalized standards";
            } else if (percentage >= 70) {
                grade = "B";
                remark = "Level 3, at agency-normalized standards";
            } else if (percentage >= 60) {
                grade = "C";
                remark = "Level 2, below, but approaching agency-normalized standards";
            } else if (percentage >= 50) {
                grade = "D";
                remark = "Level 1, well below agency-normalized standards";
            } else if (percentage >= 40) {
                grade = "E";
                remark = "Level 1-, too below agency-normalized standards";
            } else {
                grade = "R";
                remark = "Remedial standards";
            }
            System.out.println("Average Mark: " + String.format("%.2f", percentage));
            System.out.println("Grade: " + grade);
            System.out.println("Remarks: " + remark);
        } else {
            System.out.println("Invalid marks entered. Please enter marks between 0 and 100.");
        }
        sc.close();
    }
}
