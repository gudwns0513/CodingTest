/*
    핵심
    1. for문으로 모두하면 5중 for문이 나오기에 dfs로 푼다.
    
    접근
    1. 
*/
import java.util.*;
class Solution {
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs(new StringBuilder(), 0, word);
            
        return list.indexOf(word) + 1;
    }
    
    public void dfs(StringBuilder sb, int depth, String word){
        if(depth == 5) return;
        
        for(int i = 0; i < alpha.length; i++){
            sb.append(Character.toString(alpha[i]));
            list.add(sb.toString());
            dfs(sb, depth+1, word);
            sb.deleteCharAt(sb.length() - 1);  // **백트래킹**
        }
    }
    

}

