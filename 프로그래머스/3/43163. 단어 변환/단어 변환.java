/*
접근 - BFS로 풀기
1. begin이 변화할 수 있는 모든 것들을 수행
2. 수행 한 것들은 다시 수행하지 않기 위해 구분하기
3. 수행 할 때 마다 count하기
4. 가장 먼저 target이 된 단계의 count 반환하기
*/
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //단어들의 수행 여부 저장
        HashMap<String, Boolean> map = new HashMap<>();
        for(String word : words){
            map.put(word, false);
        }
        
        //[0]은 words의 인덱스, [1]은 현재까지 변환 횟수
        Queue<int[]> queue = new LinkedList<>();
        
        //begin은 words의 인덱스가 없으므로 queue에 넣지 못하니 do while을 이용해 가장 처음 시도만 구분
        do{
            String str;
            int count;
            
            if(queue.isEmpty()){
                str = begin;
                count = 0;
            }else{
                int[] current = queue.poll();
                str = words[current[0]];
                count = current[1];
            }
            
            //현재 str과 words의 단어들 모두 비교
            for(int i = 0; i < words.length; i++){
                
                //이미 거쳐간 단어는 수행 X
                if(map.get(words[i])) continue;
                
                String word = words[i];
                int diff = 0;
                
                //알파벳 1개 차이인지 비교
                for(int j = 0; j < str.length(); j++){
                    
                    if(str.charAt(j) != word.charAt(j))
                        diff++;
                }
                if(diff != 1) continue;
                
                if(words[i].equals(target))
                    return count+1;
                
                queue.offer(new int[] {i, count+1});
                map.put(words[i], true);
            } 
        }while (!queue.isEmpty());
        
        
        return answer;
    }
}