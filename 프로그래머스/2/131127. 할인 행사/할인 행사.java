import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        
        loop:
        for(int i = 0; i < discount.length - 9; i++){ //가입 날짜
            HashMap<String, Integer> map = new HashMap<>(); //hashMap 초기화
            for(int j = 0; j < want.length; j++){
                map.put(want[j], number[j]);
            }
            
            for(int k = i; k < 10 + i; k++){ //10일 할인
                if(map.containsKey(discount[k]))
                    map.put(discount[k], map.get(discount[k]) - 1);
            }
            
            for(int num : map.values()){
                if(num != 0)
                    continue loop;
            }
            answer++;
            
            
        }
        
        
        
        return answer;
    }
}