import java.util.*;
public class InvoiceGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.nextLine();
        sc.close();
        String s1 = "";
        String s2 = "";
        String[] arr = s.split(",");
        for(int i=0;i<arr[0].length();i++){
            if(arr[0].charAt(i)>='0' && arr[0].charAt(i)<='9')
                s1 += arr[0].charAt(i);
        }
        for(int i=0;i<arr[1].length();i++){
            if(arr[1].charAt(i)>='0' && arr[1].charAt(i)<='9')
                s2 += arr[1].charAt(i);
        }
        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);

        System.out.println(num1+num2);
    }
}
