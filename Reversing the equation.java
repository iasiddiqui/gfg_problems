/*Given a mathematical equation that contains only numbers and +, -, *, /. Print the equation in reverse, such that the equation is reversed, but the numbers remain the same.
It is guaranteed that the given equation is valid, and there are no leading zeros.

Example 1:

Input:
S = "20-3+5*2"
Output: 2*5+3-20
Explanation: The equation is reversed with
numbers remaining the same.
Example 2:

Input: 
S = "5+2*56-2/4"
Output: 4/2-56*2+5
Explanation: The equation is reversed with
numbers remaining the same.
Your Task:
You don't need to read input or print anything. Your task is to complete the function reverseEqn() which takes the string S representing the equation as input and returns the resultant string representing the equation in reverse.
*/




//User function Template for Java

class Solution {
    String reverseEqn(String S) {
        String[] arr = S.split("[+*-/]");
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (isOperator(c)) {
                st.push(c);
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (!st.isEmpty()) {
                sb.append(st.pop());
            }
        }

        return sb.toString();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
