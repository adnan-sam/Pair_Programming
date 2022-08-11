package Pair_Programming.Day_3;

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
}
