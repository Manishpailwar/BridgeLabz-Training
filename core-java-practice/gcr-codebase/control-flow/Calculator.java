import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        double first = sc.nextDouble();
        System.out.println("Enter operator (+, -, *, /)");
        String op = sc.next();
        System.out.println("Enter second number");
        double second = sc.nextDouble();
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                System.out.println("Result: " + (first / second));
                break;
            default:
                System.out.println("Invalid Operator");
        }
        sc.close();
    }
}
