import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() || stack.peek() != s.charAt(i))
                stack.push(s.charAt(i));
            else{
                stack.pop();
            }
        }
        
        if(stack.isEmpty())
            answer = 1;
        else
            answer = 0;

        return answer;
    }
}