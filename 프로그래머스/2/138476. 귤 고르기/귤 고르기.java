import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] index = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++){
            index[tangerine[i]] += 1;
        }
        
        index = Arrays.stream(index)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int i = 0; i < index.length; i++){
            if(k > index[i]){
                k -= index[i];
                answer++;
            }else{
                answer++;
                break;
            }
        }
        
        
        return answer;
    }
        
}