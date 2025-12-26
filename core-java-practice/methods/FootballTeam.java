import java.util.Arrays;

public class FootballTeam {
    public static void main(String[] args) {
        int[] heights = new int[11];
        
        // Generate random heights between 150 and 250
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
        }

        System.out.println("Player Heights: " + Arrays.toString(heights));
        System.out.println("Sum of Heights: " + findSum(heights));
        System.out.println("Mean Height: " + String.format("%.2f", findMean(heights)));
        System.out.println("Shortest Height: " + findShortest(heights));
        System.out.println("Tallest Height: " + findTallest(heights));
    }

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) sum += h;
        return sum;
    }

    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) min = h;
        }
        return min;
    }

    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) max = h;
        }
        return max;
    }
}