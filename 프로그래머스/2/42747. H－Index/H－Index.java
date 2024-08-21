import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        citations = Arrays.stream(citations) //스트림 연습
            .boxed()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int i = 0; i < citations[citations.length-1]; i++){
            for(int j = 0; j < citations.length; j++){
                
                if(citations[j] >= i){
                    int h = citations.length - j;
                    
                    if(i <= h) answer = i;
                }
                
                
            }
        }
        
        return answer;
    }
}