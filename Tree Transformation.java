/*

You are given a tree containing N nodes in the form of an array P where Pi represents the parent of the i-th node and P0 = -1 as the tree is rooted at node 0. In one move, you can merge any two adjacent nodes. Calculate the minimum number of moves required to turn the tree into a star tree.

-> Merging adjacent nodes means deleting the edge between them and considering both the nodes as a single one.
-> A Star tree is a tree with a center node, and all other nodes are connected to the center node only.

Example 1:

Input:
N = 5
p[] = {-1, 0, 0, 1, 1}
Output:
1
Explanation: 
Tree looks like:
            
Merge the edge 0 - 2 in one operation

Our Tree will look like:


Your Task:
You don't need to read, input, or print anything. Your task is to complete the function solve( ), which takes integer N, and an array p[ ] as input parameters and returns the minimum number of moves required to turn the tree into a star tree.
            

*/





class Solution {
    public static int solve(int N, int[] p) {
        int[] arr = new int[N];
       
        
        for (int i = 1; i < N; i++) {
            arr[p[i]]++;
            arr[i]++;
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        
        if (count == N) {
            return 0;
        }
        
        return N - 1 - count;
    }
}
        
        
