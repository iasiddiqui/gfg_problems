/*Given three stacks S1, S2 & S3 of size N1, N2 & N3 respectively, having only Positive Integers. The task is to find the possible equal maximum sum of the stacks with the removal of top elements allowed. Stacks are represented as an array, and the first index of the array represents the top element of the stack.

Example 1:

Input:
N1 = 3, N2 = 4, N3 = 2
S1 = {4,2,3}
S2 = {1,1,2,3}
S3= {1,4}
Output:
5
Explanation:
We can pop 1 element from the 1st stack, and 2
elements from the 2nd stack. Now remaining elements
yield the equal sum of the three stacks, that is 5.
Example 2:

Input:
N1 =2, N2 = 1, N3 = 3
S1 = {4,7}
S2 = {10}
S3 = {1,2,3}
Output:
0
Explanation:
We will never get an equal sum after popping
some elements, so the answer will be 0.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxEqualSum() which takes the arrays S1[], S2[], and S3[] and their sizes N1, N2, and N3 as inputs and returns the maximum equal sum we can obtain.*/





class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        
        int s1[]= new int[N1];
        int s2[]= new int[N2];
        int s3[]= new int[N3];
        
        s1[N1-1] = S1[N1-1];  
        s2[N2-1] = S2[N2-1];  
        s3[N3-1] = S3[N3-1];  
        
        for(int i = N1-2; i>=0; i--){
            s1[i] = S1[i] + s1[i+1];
        }
        for(int i = N2-2; i>=0; i--){
            s2[i] = S2[i] + s2[i+1];
        }
        for(int i = N3-2; i>=0; i--){
            s3[i] = S3[i] + s3[i+1];
        }
        
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        
        while(p1<N1 && p2<N2 && p3<N3){
        
            int min = Math.min(s1[p1], Math.min(s2[p2], s3[p3]));
            while(p1<N1 && s1[p1]>min){
                p1++;
            }
            while(p2<N2 && s2[p2]>min){
                p2++;
            }
            while(p3<N3 && s3[p3]>min){
                p3++;
            }
            if(p1<N1 && p2<N2 && p3<N3)
                if(s1[p1] == s2[p2] && s2[p2] == s3[p3])
                    return s1[p1];
        }
        
        return 0;
    }  
}    
