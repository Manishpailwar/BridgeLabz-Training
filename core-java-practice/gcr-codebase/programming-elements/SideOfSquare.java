import java.util.Scanner;

public class SideOfSquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int perimeter=sc.nextInt();
        int sideLength=perimeter/4;
        System.out.println("The length of the side is "+sideLength+" whose perimeter is "+perimeter);
        sc.close();
    }
}