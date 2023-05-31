/*You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists at an equal distance, choose the smallest one.

Example 1:

Input:
2 → 6 → 10
Output:
2 → 5 → 11
Explanation:
The nearest prime of 2 is 2 itself.
The nearest primes of 6 are 5 and 7,
since 5 is smaller so, 5 will be chosen.
The nearest prime of 10 is 11.
 

Example 2:

Input:
1 → 15 → 20
Output:
2 → 13 → 19
Explanation:
The nearest prime of 1 is 2.
The nearest primes of 15 are 13 and 17,
since 13 is smaller so, 13 will be chosen.
The nearest prime of 20 is 19.
Your Task:
The task is to complete the function primeList() which contains a reference to the head as the only argument. This function should return the head of the modified linked list.*/


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
        //code here
        Node curr=head;
        while(curr!=null){
            if(!isPrime(curr.val)){
                int t1=curr.val;
                int t2=curr.val;
                while(true){
                    t1--;
                    t2++;
                    if(isPrime(t1)){
                        curr.val=t1;
                        break;
                    }
                    if(isPrime(t2)){
                        curr.val=t2;
                        break;
                    }
                }
            }
            curr=curr.next;
        }
        return head;
    }
    boolean isPrime(int num){
        if(num==2 || num==3){
            return true;
        }
        if(num==1 || num%2==0 || num%3==0){
            return false;
        }
        for(int i=5;i*i<=num;i=i+6){
            if(num%i==0 || num%(i+2)==0){
                return false;
            }
        }
        return true;
    }
     
}
