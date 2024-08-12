import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> card1 = new ArrayDeque<>();
        Queue<String> card2 = new ArrayDeque<>();
        
        for(String str : cards1)
            card1.add(str);
        
        for(String str : cards2)
            card2.add(str);
        
        for(String str : goal){
            if(!card1.isEmpty() && card1.peek().equals(str))
                card1.poll();
            else if(!card2.isEmpty() && card2.peek().equals(str))
                card2.poll();
            else{
                answer = "No";
                return answer;
            }
        answer = "Yes";
            
        }
        return answer;
    }
}