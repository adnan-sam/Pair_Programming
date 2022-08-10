package Pair_Programming.Day_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Find_dups {
    public static void main(String[] args) {
        int[] a={2,3,1,2,3}; // Test Case - 1
        // int[] a={0,3,1,2};
        System.out.println("First Approach -");
        ArrayList<Integer> ans1=duplicates1(a,a.length);
        System.out.println(ans1);
        System.out.println("Second Approach -");
        ArrayList<Integer> ans2=duplicates2(a,a.length);
        System.out.println(ans2);
        System.out.println("Third Approach -");
        ArrayList<Integer> ans3=duplicates3(a,a.length);
        System.out.println(ans3);
        System.out.println("Fourth Approach -");
        ArrayList<Integer> ans4=duplicates3(a,a.length);
        System.out.println(ans4);
        System.out.println("Fifth Approach -");
        ArrayList<Integer> ans5=duplicates3(a,a.length);
        System.out.println(ans5);
    }
    // Approach 1 - Brute force solution (Checking for each variable if there is a duplicate present or not) O(N^2) [TLE toh aana hi h]
    static ArrayList<Integer> duplicates1(int[] arr,int n) {
        ArrayList<Integer> res=new ArrayList<>();
        //Base case below
        if(arr.length<=1 || arr==null) {
            res.add(-1);
            return res;
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr[i]==arr[j]) {
                    res.add(arr[i]);
                }
            }
        }
        if(res.size()==0) {
            res.add(-1);
        }
        Collections.sort(res); //As in Q it is mentioned we have to return the ans in sorted order
        return res;
    }
    // Approach 2 - Using Sorting and comparing the next element O(N log N) + O(N) [Something is wrong here]
    static ArrayList<Integer> duplicates2(int[] arr, int n) {
        ArrayList<Integer> res=new ArrayList<>();
        //Base case below
        if(arr.length<=1 || arr==null) {
            res.add(-1);
            return res;
        }
        Arrays.sort(arr);
        int i=1,j=0;
        while(i<n) {
            if(arr[i]==arr[j] && !res.contains(arr[i])) {
                res.add(arr[i]);
            }
            i++;
            j++;
        }
        if(res.size()==0) {
            res.add(-1);
        }
        return res;
    }
    //Approach 3 - Using Sorting and 4 pointer approach [TLE at 331 test case]
    // T.C - O(N log N)+O(log N)+O(N log N)
    public static ArrayList<Integer> duplicates3(int arr[], int n) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        //Base case below
        if(arr.length<=1 || arr==null) {
            res.add(-1);
            return res;
        }
        Arrays.sort(arr);
        int lo=0,hi=n-1;
        int i=1,j=n-2;
        while(lo<=hi) {
            if(arr[i]==arr[lo] && !res.contains(arr[lo])) {
                res.add(arr[lo]);
            }
            if(arr[hi]==arr[j] && !res.contains(arr[hi])) {
                res.add(arr[hi]);
            }
            lo++;
            i++;
            hi--;
            j--;
        }
        if(res.size()==0) {
            res.add(-1);
        }
        Collections.sort(res);
        return res;
    }
    // Approach 4 - Using an extra space like an array of size n or it's better if we use HashSet. [Caused TLE on GFG at 324 test case]
    // O(N)+O(N log N)+O(N log N) Time & O(N) Space
    static ArrayList<Integer> duplicates4(int[] arr, int n) {
        ArrayList<Integer> res=new ArrayList<>();
        //Base case below
        if(arr.length<=1 || arr==null) {
            res.add(-1);
            return res;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) {
            if(set.contains(arr[i]) && !res.contains(arr[i])) {
                res.add(arr[i]);
                // set.remove(arr[i]);
            }
            else {
                set.add(arr[i]);
            }
        }
        if(res.size()==0) {
            res.add(-1);
            return res;
        }
        Collections.sort(res); //Because the Q says we have to return it in sorted order
        return res;
    }
    //I tried to solve using TreeSet too
    //Approach 5 - Using HashSet (Optimal approach)
    static ArrayList<Integer> duplicates5(int[] arr, int n) {
        //If we are adding base case here then it's giving exception in thread error at input n=1 and arr={0}
        HashSet<Integer>set=new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                set.add(arr[i]);
            }
        }
        
        ArrayList<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        if(list.size()>0)
        return list;
        
        list.add(-1);
        return list;
    }
}
