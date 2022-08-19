package Day_1;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr={0,2,2,1,0,2,0,1};
        // sortOne(arr,arr.length);
        sortTwo(arr,arr.length);
        for(int i:arr)
        System.out.print(i+" ");
    }
    //First approach --> Counting Approach
    /** Here we will basically traverse through the array and store the count of 0,1 and 2's and will store all of them in another
     * traversal */
    // T.C - O(N) S.C - O(1)
    public static void sortOne(int[] a, int n) {
        int zero=0,one=0,two=0;
        for(int i=0;i<n;i++) {
            if(a[i]==0)
                zero++;
            else if(a[i]==1)
                one++;
            else
                two++;
        }
        int i=0;
        while(zero>0) {
            a[i]=0;
            i++;
            zero--;
        }
        while(one>0) {
            a[i]=1;
            i++;
            one--;
        }
        while(two>0) {
            a[i]=2;
            i++;
            two--;
        }
    }
    //Second Approach --> Traversal and swapping //Dutch National Flag Algorithm using 3 pointers
    // T.C - O(N) S.C - O(1)
    public static void sortTwo(int[] arr, int n) {
        int low=0,high=n-1;
        int mid=0;
        while(mid<=high)
        {
            if(arr[mid]==0)
            {
                int temp=arr[low];
                arr[low]=arr[mid]; //arr[low]=0;
                arr[mid]=temp;
                low++;
            }
            else if(arr[mid]==2)
            {
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
                mid--;
            }
            mid++;
        }
    }
}

