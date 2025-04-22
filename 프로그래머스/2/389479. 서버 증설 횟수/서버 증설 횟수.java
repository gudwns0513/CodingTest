/*
    - 접근
    1. 현재 이용자 수에서 증설되어있는 서버로 커버가 되면 넘기기
    2. k시간이 지나면 증설된 서버를 내리기
    3. 서버 증설할 때 마다 카운트하기
*/
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Integer> currentServer = new ArrayList<>();
        for(int i = 0; i < players.length; i++){
            
            //k시간이 지난 서버는 삭제
            for(int j = 0; j < currentServer.size(); j++){
                currentServer.set(j, currentServer.get(j) + 1);
                
                if(currentServer.get(j) > k){
                    currentServer.remove(j);
                    j--; // 인덱스 조정
                }
            }
            
            //현재 이용자 수에서 필요한 서버를 증설
            while(players[i] >= (currentServer.size() + 1) * m){
                currentServer.add(1);
                answer++;
            }
        }
        return answer;
    }
}