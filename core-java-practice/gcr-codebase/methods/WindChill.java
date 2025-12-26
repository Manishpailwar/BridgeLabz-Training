import java.util.Scanner;

public class WindChill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature (F): ");
        double temp = scanner.nextDouble();
        System.out.print("Enter wind speed (mph): ");
        double speed = scanner.nextDouble();
        
        double windChill = calculateWindChill(temp, speed);
        System.out.println("Wind Chill Temperature: " + windChill);
        scanner.close();
    }

    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}