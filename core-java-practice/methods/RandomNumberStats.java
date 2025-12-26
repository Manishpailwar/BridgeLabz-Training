import java.util.Arrays;

public class RandomNumberStats {
    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        
        System.out.println("Generated Numbers: " + Arrays.toString(randomNumbers));
        
        double[] stats = findAverageMinMax(randomNumbers);
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + (int)stats[1]);
        System.out.println("Maximum: " + (int)stats[2]);
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            // Generate random number between 1000 and 9999
            numbers[i] = 1000 + (int)(Math.random() * 9000);
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) return new double[]{0, 0, 0};

        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }
}