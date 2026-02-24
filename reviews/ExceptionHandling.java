import java.util.*;
public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter Integer less than 10 :");
        try{
            int num = sc.nextInt();
            sc.close();
            if(num > 10)
                throw new Exception("Integer must be less than 10 !");
            System.out.println("Thanks");
        }catch(InputMismatchException e){
            System.out.println("Invalid Input!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
