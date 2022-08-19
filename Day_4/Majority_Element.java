package GeeksForGeeks;

import java.util.HashMap;
import java.util.Scanner;

public class Majority_Element {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the size - ");
//        int sz=sc.nextInt();
//        System.out.println("Enter the elements - ");
//        int[] a=new int[sz];
//        for(int ele:a) {
//            ele=sc.nextInt();
//        }
//        TestCase
        int[] a={2,2,2,4,4,5,2,4};
        int sz=a.length;

        System.out.println("HashMap Approach -- O(N) Time and O(N) Space --");
        System.out.println(majorityElementMap(a, sz)); //O(N) Time O(N) Space
        System.out.println("Brute Force Approach -- O(N^2) Time and O(1) Space --");
        System.out.println(majorityElementBrute(a,sz));
        System.out.println("Moore's Voting Algorithm -- O(N) Time and O(1)Space -- Optimal Approach --");
        System.out.println(majorityElementMoore(a,sz));
    }
//    Using Moore's Voting Algorithm
    static int majorityElementMoore(int[] a, int size) {
        int ele=-1,c=0;
//        Assuming that majority element always appears in the array
        for(int i=0;i<size;i++) {
            if(c==0)
                ele=a[i];
            if(a[i]==ele)
                c++;
            else {
                c--;
                if(c==0)
                ele=-1;
            }
        }
        return ele;
    }
//    Using HashMap
    static int majorityElementMap(int a[], int size)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:a) {
            map.put(ele,map.getOrDefault(ele,0)+1);
            if(map.containsKey(ele)) {
                if(map.get(ele)>(size/2))
                    return ele;
            }
        }
        return -1;
    }
//    Using Brute Force
    static int majorityElementBrute(int[] a, int size) {
        int c=0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length;j++) {
                if(a[j]==a[i])
                    c++;
            }
            if(c>(size/2))
                return a[i];
            else
                c=0;
        }
        return -1;
    }
}
