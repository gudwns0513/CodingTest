import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s + s;
        
        
        
        for(int r = 0; r < s.length(); r++){
            Stack<Character> stack = new Stack<>();
            for(int i = r; i < s.length() + r; i++){
                if(str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{')
                    stack.push(str.charAt(i));
            
                if(!stack.isEmpty()){
                    if(str.charAt(i) == ']'){
                        if(stack.peek() == '[')
                            stack.pop();
                    }
                    else if(str.charAt(i) == ')'){
                        if(stack.peek() == '(')
                            stack.pop();
                    }
                    else if(str.charAt(i) == '}'){
                        if(stack.peek() == '{')
                            stack.pop();
                    }
                }else{
                    if(str.charAt(i) == ']' || str.charAt(i) == ')' || str.charAt(i) == '}')
                        stack.push(str.charAt(i));
                }
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}