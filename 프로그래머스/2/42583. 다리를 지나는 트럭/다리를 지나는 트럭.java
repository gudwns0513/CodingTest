/*
    1. 트럭 한 대 보내기 (1초 경과)
    2. 다리 위의 무게 + 새로 들어올 트럭 무게가 weight보다 크면 0, 작으면 새로운 트럭 추가(1초 경과)
    3. 다리 길이만큼 시간이 지났다면 1초마다 트럭을 빼기(0도 트럭으로 가정)
    4. 다리 위에 아무것도 없으면 시간 반환
*/

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        int currentWeight = 0;
        int index = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        bridge.offer(truck_weights[0]);
        currentWeight += truck_weights[0];
        answer++;
        index++;
        
        if(truck_weights.length == 1)  
            return bridge_length + 1;
        
        while(!bridge.isEmpty()){ 
            
            answer++;
            
            //트럭 빼거나 0 빼기
            if(answer > bridge_length){
                currentWeight -= bridge.poll();
            }
                                 
            //마지막 인덱스 이후엔 아무것도 넣지 않음
            if(index <= truck_weights.length-1){
                
                //트럭 넣거나 0 넣기
                if(currentWeight + truck_weights[index] > weight)
                    bridge.offer(0);
                else{
                    bridge.offer(truck_weights[index]);
                    currentWeight += truck_weights[index];
                    index++;
                }
            }
            
            
            
            
        }
        
        return answer;
    }
}