import java.util.*;
public class StudentsScoreAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Enter Total No. of Students: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        int sum = 0 ;
        for(int i=0;i<size;i++){
            System.out.println("Enter Marks of Student No."+(i+1)+" : ");
            try{
            arr[i] = sc.nextInt();
            if(arr[i] < 0)
                throw new Exception("Marks cannot be less than 0 !");
            else if(arr[i] > 100)
                throw new Exception("Marks cannot be greater than 100 !");
            else
            sum += arr[i];
            }catch(InputMismatchException e){
                System.out.println("Invalid Input !");
                sc.next();
                i--;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                i--;
            }
        }
        
        System.out.println("Average Marks Of All the Students : "+sum/size);
        Arrays.sort(arr);
        System.out.println("Highest Marks : "+arr[size-1]);
        System.out.println("Lowest Marks : "+arr[0]);
        System.out.println("Score Above The Average Are : ");
        for(int i=0;i<size;i++){
            if(arr[i] > sum/size){
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }
}
