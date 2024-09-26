import java.util.*;
class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        StringBuilder reverse = new StringBuilder();
        int[] answer = new int[str.length()];
        
        for(int i = str.length()-1; i >= 0; i--){
            answer[str.length()-1 - i] = str.charAt(i) - '0';
        }
        
        return answer;
    }
}