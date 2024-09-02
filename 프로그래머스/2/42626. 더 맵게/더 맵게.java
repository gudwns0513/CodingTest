import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        int mix = 0;
        for(int num : scoville){
            queue.offer(num);
        }
        
        while(true){
            int first = queue.poll();
            if(first >= K)
                break;
            if(queue.size() == 0){
                return -1;
            }
            
            int second = queue.poll();
            
            
            
            
            
            mix = first + second * 2;
            queue.offer(mix);
            answer++;
        }
            
            
        return answer;
    }
}