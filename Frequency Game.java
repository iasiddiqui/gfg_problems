/*Given an array A of size N. The elements of the array consist of positive integers. You have to find the largest element with minimum frequency.

Example 1:

Input: 
5
2 2 5 50 1
Output:
50
Explanation :
All elements are having frequency 1 except 2.
50 is the maximum element with minimum frequency.
Example 2:

Input:
4
3 3 5 5
Output:
5
Explanation:
Both 3 and 5 have the same frequency, so 5 should be returned.
User Task:
Your task is to complete the provided function LargButMinFreq(A, n) which accepts array A and n. Hence you have to return the largest element with minimum frequency.*/



class Solution {
    public static int LargButMinFreq(int arr[], int n) {
        Arrays.sort(arr);
        int dp[] = new int[arr[n-1]+1];
        for(int i=0;i<n;i++)
        dp[arr[i]]++;
       int min=Integer.MAX_VALUE;
       int max=0;
        for(int i=0;i<dp.length;i++)
        {
           if(dp[i]==0) 
           continue;
           else if(dp[i]<=min)
           {
               if(max<i)
               {
               min=dp[i];
               max=i;
               }
           }
        }
    return max;
        
    }
    
}
 
