import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] handOutDay = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            queue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        /*
            두 가지 경우 생각
            1. 뽑은 애가 마지막 process일 경우 
            2. 쭉 뽑다가 queue가 비어버리면?
        */
        while(true){
            int count = 1; //같은 날 배포되는 프로세스 수
            int day = 0;
            if(!queue.isEmpty()) //비어있지 않으면 가장 첫 프로세스 뽑기
                day = queue.poll();
            else
                break;
            
            //queue가 비어있지 않고 첫 프로세스의 기간보다 작거나 같은 애들 모두 뽑기
            while(!queue.isEmpty() && queue.peek() <= day){ 
                queue.poll();
                count++;
            }
            
            list.add(count);
            
        }
        
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
