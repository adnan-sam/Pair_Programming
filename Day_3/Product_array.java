package Day_3;

// 238. Product of Array Except Self
/** Problem Statement -
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation. */

public class Product_array {
    public static void main(String[] args) {
        int[] nums={5,2,2,4}; //Output should be - {16,40,40,20};
        
        int[] ans1=productExceptSelf_BruteForce(nums);
        for(int ele:ans1)
        System.out.print(ele+" ");
        System.out.println();
        
        int[] ans2=productExceptSelf_Div(nums);
        for(int ele:ans2)
        System.out.print(ele+" ");
        System.out.println();

        // We have to reinitialise nums as in the above call nums has been changed
        int[] nums2={5,2,2,4}; //Output should be - {16,40,40,20};
        int[] ans3=productExceptSelf_1(nums2);
        for(int ele:ans3)
        System.out.print(ele+" ");
        System.out.println();

        // We have to reinitialise nums as in the above call nums has been changed
        int[] nums3={5,2,2,4}; //Output should be - {16,40,40,20};
        int[] ans4=productExceptSelf_1(nums3);
        for(int ele:ans4)
        System.out.print(ele+" ");
        System.out.println();
    }

    //Brute Force Approach [O(N^2)]
    static int[] productExceptSelf_BruteForce(int[] arr) {
        int[] ans= new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            int pro=1;
            for(int j=0;j<arr.length;j++) {
                if(i==j)
                    continue;
                else
                    pro*=arr[j];
            }
            ans[i]=pro;
            pro=1;
        }
        return ans;
    }
    //Quite Optimal using division O(2N) -> O(N) || Space - O(1) {We are creating no extra array for returning}
    static int[] productExceptSelf_Div(int[] arr) {
        int totalPro=1;
        for(int i=0;i<arr.length;i++) {
            totalPro*=arr[i];
        }
        for(int i=0;i<arr.length;i++) {
            arr[i]=totalPro/arr[i];
        }
        return arr;
    }
    //Optimal Approach which LeetCode wants, T.C - O(N) || S.C - O(2N)

/** Create two arrays leftPro and rightPro which will be storing the left product
 * and right product of the elements till ith index respectively.
 * Traverse the array and store arr[i] = leftPro[i-1] * rightPro[i+1];
 * This will take O(N) time and hence we are not creating any extra array for storing the output so though we are creating
 * leftPro and rightPro so we can say that we are using O(N) space bt still it get's neglected as in the Problem statement
 * it is mentioned that they are providing us with O(N) space for storing the output and hence we are utilising it in leftPro
 * and rightPro arrays so we can assume that it is taking O(1) space. */

    static int[] productExceptSelf_1(int[] arr) {
        int[] leftPro = new int[arr.length];
        int[] rightPro = new int[arr.length];
        int pro=1;
        for(int i=0;i<arr.length;i++) {
            pro*=arr[i];
            leftPro[i]=pro;
        }
        pro=1;
        for(int i=arr.length-1;i>=0;i--) {
            pro*=arr[i];
            rightPro[i]=pro;
        }
        //Let's fill the outputs in the same array arr
        for(int i=0;i<arr.length;i++) {
            if(i==0) {
                arr[i] = rightPro[i+1];
            }
            else if(i==arr.length-1) {
                arr[i] = leftPro[i-1];
            }
            else {
                arr[i] = leftPro[i-1]*rightPro[i+1];
            }
        }
        return arr;
    }
    /** Optimal Approach 2 -

The procedure is same as above but here we are creating only 1 left array and updating it using a cumulative product variable. */
    public int[] productExceptSelf_2(int[] arr) {
        int[] leftPro = new int[arr.length];
        int[] rightPro = new int[arr.length];
        int pro=1;
        // Filling leftPro array
        for(int i=0;i<arr.length;i++) {
            pro*=arr[i];
            leftPro[i]=pro;
        }
        //Let's fill the outputs in the same array arr
        pro=1;
        for(int i=arr.length-1;i>0;i--) {
                leftPro[i] = leftPro[i-1]*pro;
                pro*=arr[i];
        }
        leftPro[0]=pro;
        
        return leftPro;
    }
}
