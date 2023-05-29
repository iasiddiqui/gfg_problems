/*Given a dictionary of words where each word follows CamelCase notation, print all words (in lexicographical order) in the dictionary that match with a given pattern consisting of uppercase characters only.

Example: GeeksForGeeks matches the pattern "GFG", because if we combine all the capital letters in GeeksForGeeks they become GFG.

CamelCase is the practice of writing compound words or phrases such that each word or abbreviation begins with a capital letter. Common examples include PowerPoint and Wikipedia, GeeksForGeeks, CodeBlocks, etc.

Example 1:

Input:
N=3
Dictionary=["WelcomeGeek",
"WelcomeToGeeksForGeeks","GeeksForGeeks"]
Pattern="WTG"
Output:
WelcomeToGeeksForGeeks
Explanation:
Since only WelcomeToGeeksForGeeks matches 
the pattern, it is the only answer.
Example 2:

Input:
N=8
Dictionary=["Hi","Hello","HelloWorld",
"HiTech","HiGeek","HiTechWorld",
"HiTechCity","HiTechLab"]
Pattern="HA"
Output:
-1
Explanation:
Since the pattern matches none of the words
of the string,the output is -1.
Your Task:
You don't need to read input or print anything. Your Task is to complete the function CamelCase() which takes an integer N, a Vector of strings Dictionary and a string Pattern and returns the strings in the dictionary that match the pattern, if not found any return -1.
*/

//User function Template for Java

class Solution
{
    public static boolean findPattern(String str, String pat)
    {
        int n = pat.length();
        
        String x = "";
        
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            
            if(Character.isUpperCase(ch))
            {
                x += ch;
            }
        }
     //   System.out.println(x);
       if(x.length() < n)
            return false;
            
        String ans = "";
        for(int i = 0; i < n; i++)
        {
            ans += x.charAt(i);
        }
      
        if(pat.equals(ans))
            return true;
            
        return false;
    }
    
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern)
    {
        //code here
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++)
        {
            String str = Dictionary[i];
            boolean status = findPattern(str, Pattern);
            
            if(status)
                list.add(str);
        }
        
        Collections.sort(list);
        if(list.size() == 0)
        {
            list.add("-1");
            return list;
        }
        return list;
    }
}
