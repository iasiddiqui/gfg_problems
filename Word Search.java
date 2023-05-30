/*Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.

Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0
Your Task:
You don't need to read or print anything. Your task is to complete the function isWordExist() which takes board and word as input parameter and returns boolean value true if word can be found otherwise returns false.
*/
class Solution
{
    public boolean help(char[][] board, String word, int i, int j,int index)
    {
        // Code here
        if(index == word.length())
        return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j] != word.charAt(index))
        return false;
        board[i][j] ='_';
        index ++;
        
        boolean a = help(board,word,i+1,j,index) || help(board,word,i-1,j,index) || help(board,word,i,j+1,index) || help(board,word,i,j-1,index);
        board[i][j] = word.charAt(index-1);
        return a;
    }
    
     public boolean isWordExist(char[][] board, String word)
     {
         for(int i=0; i<board.length; i++)
         {
             for(int j=0; j<board[i].length; j++)
             {
                 if(board[i][j] == word.charAt(0))
                 {
                     boolean a = help(board,word,i,j,0);
                     if(a==true)
                     return a;
                 }
             }
         }
         return false;
     }
}
