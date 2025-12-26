import java.util.Scanner;

public class StudentScoreCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        double[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);

        displayScorecard(scores, results);
        scanner.close();
    }

    public static double[][] generateScores(int n) {
        double[][] scores = new double[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 10 + (int)(Math.random() * 90); // Physics
            scores[i][1] = 10 + (int)(Math.random() * 90); // Chemistry
            scores[i][2] = 10 + (int)(Math.random() * 90); // Math
        }
        return scores;
    }

    public static double[][] calculateResults(double[][] scores) {
        double[][] results = new double[scores.length][3]; // Total, Avg, Percentage
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScorecard(double[][] scores, double[][] results) {
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\t%");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.2f\t%.2f\t%.2f\n", 
                (i + 1), 
                scores[i][0], scores[i][1], scores[i][2], 
                results[i][0], results[i][1], results[i][2]);
        }
    }
}