/*
    접근
    1. PriorityQueue에 priorities를 모두 삽입
    2. PriorityQueue가 null일 때 까지 while문 실행
    4. priorities의 값을 순서대로 뽑아서 PriorityQueue에서 뽑은 값과 비교
        4-1. 같다면 answer++, PriorityQueue에서 값 삭제(프로세스 실행)
        4-2. location과 priorities의 index비교
            4-2-1. 같다면 answer 반환
*/  
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        //location이 몇번째 실행인지 저장
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        
        
        for(int num : priorities){ //1
            queue.offer(num);
        }
        
        //9 1 1 1 1 1
        while(!queue.isEmpty()){ //2
            for(int i = 0; i < priorities.length; i++){
                
                if(priorities[i] == queue.peek()){ //4
                    
                    //4-1
                    answer++;
                    System.out.println(queue.poll()); 
                    
                    if(location == i) //4-2
                        return answer; //4-2-1
                } 
                    
                    
                    
            }
        }
        return answer;
    }
}