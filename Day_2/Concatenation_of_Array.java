package Day_2;

public class Concatenation_of_Array {
    public static void main(String[] args) {
        int[] nums={1,2,4,5,1};
        System.out.println("First approach -");
        int[] ans1=getConcatenation1(nums);
        for(int ele:ans1)
        System.out.print(ele+" ");
        System.out.println();
        System.out.println("Second approach -");
        int[] ans2=getConcatenation2(nums);
        for(int ele:ans2)
        System.out.print(ele+" ");
    }
    // Approach 1 - [Brute Force] Running for loop 2 times
    static int[] getConcatenation1(int[] nums) {
        int len=nums.length+nums.length;
        int[] ans=new int[len];
        int index=0;
        for(int i=0;i<nums.length;i++) {
            ans[index]=nums[i];
            index++;
        }
        for(int i=0;i<nums.length;i++) {
            ans[index]=nums[i];
            index++;
        }
        return ans;
    }
    // Approach 2 - [Optimal] Running for loop 1 time and filling 2 indexes simultaneously
    static int[] getConcatenation2(int[] nums) {
        int len=nums.length+nums.length;
        int[] ans=new int[len];
        int ind1=0,ind2=nums.length;
        for(int i=0;i<nums.length;i++) {
            ans[ind1]=nums[i];
            ans[ind2]=nums[i];
            ind1++;
            ind2++;
        }
        return ans;
    }
}
