import java.util.*;
public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter Size of Array : ");
        int size = sc.nextInt();
        System.out.println("Enter Array Elements : ");
        int nums[] = new int[size];
        for(int i=0;i<size;i++)
            nums[i]=sc.nextInt();
        sc.close();
        int ind = 0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0)
                nums[ind++] = nums[i] ;
        }
        for(;ind<nums.length;ind++){
            nums[ind] = 0 ;
        }
        System.out.println(Arrays.toString(nums));
    }
}
