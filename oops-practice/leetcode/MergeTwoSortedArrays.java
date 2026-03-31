import java.util.*;
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Size of Array nums1 : ");
        int size1 = sc.nextInt();

        System.out.print("Size of Array nums2 : ");
        int size2 = sc.nextInt();

        int[] nums1 = new int[size1];
        System.out.println("Enter Elements of Array nums1 : ");
        for(int i=0;i<size1;i++)
            nums1[i] = sc.nextInt();

        int[] nums2 = new int[size2];
        System.out.println("Enter Elements of Array nums2 : ");
        for(int i=0;i<size2;i++)
            nums2[i] = sc.nextInt();   

        System.out.print("m : ");
        int m = sc.nextInt();

        System.out.print("n : ");
        int n = sc.nextInt();

        int i= m-1;
        int j = n-1;
        int ind = m+n-1 ;
        while(j>=0){
            if(i>=0 && nums1[i] > nums2[j])
                nums1[ind] = nums1[i--];
            else
                nums1[ind] = nums2[j--];
            ind--;
        }
        while(i>=0){
            nums1[ind--] = nums1[i--];
        }
        System.out.println(Arrays.toString(nums1));
        sc.close();
    }
}
