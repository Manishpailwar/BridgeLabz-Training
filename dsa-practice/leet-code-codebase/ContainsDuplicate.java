import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Array :");
        int size = sc.nextInt();
        System.out.println("Enter Array Elements :");
        int nums[] = new int[size];
        for(int i=0;i<size;i++)
            nums[i]=sc.nextInt();
        sc.close();
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])==true){
                System.out.println("True");
                return;
            }
            else
            map.put(nums[i],nums[i]);
        }
        System.out.println("False");
    }
}
