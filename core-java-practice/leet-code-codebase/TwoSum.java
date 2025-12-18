import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Target = ");
        int target = sc.nextInt();
        System.out.print("Array Size = ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(twoSum(arr,target)));
        sc.close();
        
    }
}
