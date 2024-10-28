import java.lang.*;
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            queue.offer(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            int num = queue.poll();
            
            if(num == 0){
                return 0;
            }
            
            queue.offer(num-1);
        }
        
        while(!queue.isEmpty()){
            answer += Math.pow(queue.poll(), 2);
        }
        
        
        return answer;
    }
}