package Day_1;
import java.util.Arrays;

public class missing_number {
    public static void main(String[] args) {
        // int arr[]={0,1,2,6,5,4};
        int arr[]={1,3,4};
        int res=missingNumber(arr);
        System.out.println(res);
    }
    static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int min=arr[0];
        int max=arr[arr.length-1];
        int i=0;
        for(int num=min;num<max;num++) {
            if(arr[i]!=num)
            {
                return num;
            }
            i++;
        }
        return max+1;
    }
}
