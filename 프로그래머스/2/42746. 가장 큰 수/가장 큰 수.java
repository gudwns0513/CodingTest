import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        //int배열 -> String배열
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strs[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.stream(strs)
            .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
            .forEach(str -> answer.append(str));
        
        if(answer.toString().startsWith("0"))
            return "0";
        
        return answer.toString();
    }
}