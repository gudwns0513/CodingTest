import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        
        //큐에 원소들을 모두 집어넣고 모든 원소들의 합 계산
        for(int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }
        
        //하나의 큐가 가져야 할 수
        long goal = (q1Sum + q2Sum) / 2;
        
        
        while(q1Sum != goal){
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            
            if(q1Sum < q2Sum){
                q2Sum -= (long)q2.peek();
                q1Sum += (long)q2.peek();
                q1.offer(q2.poll());
            }else if (q2Sum < q1Sum){
                q1Sum -= (long)q1.peek();
                q2Sum += (long)q1.peek();
                q2.offer(q1.poll());
            }else{
                return answer;   
            }
            answer++;
        }
        
        if(q1Sum != goal) return -1;

        
        return answer;
        
    }
}