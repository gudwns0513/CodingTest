/*
    접근
    1. 자신의 원래번호와 바뀌는 번호를 저장하는 배열을 생성
    2. a번과 b번은 무조건 이기게하고 나머지 경기는 아무나 이기게 하기
    3. list에 이긴애들을 순서대로 다시 삽입(list는 매번 초기화)
    4. a번과 b번이 만나면 answer을 return
*/
import java.util.*;
class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        //배열 인덱스로 계산하기 위해 -1하기
        a = a-1;
        b = b-1;
        
        for(int i = 0; i < n; i++){
            queue.offer(new int[] {i, i});
        }
        
        
        int gameCount = n/2;
        for(int i = 0; i < n / 2; i++){
            answer++;
            for(int j = 0; j < gameCount; j++){
                int[] player1 = queue.poll();
                int[] player2 = queue.poll();
                player1[1] = j;
                player2[1] = j;
                
                if((player1[0] == a && player2[0] == b) ||(player1[0] == b && player2[0] == a)){
                    return answer;
                }

                if(player1[0] == a || player1[0] == b){
                    queue.offer(player1);
                }else{
                    queue.offer(player2);
                }
            }
            gameCount /= 2;
        }
        


        return answer;
    }
}