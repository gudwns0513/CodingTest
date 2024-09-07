/*
    접근
    1. 캐시의 데이터 수가 cacheSize보다 작으면 데이터 삽입
    2. 캐시의 데이터 수가 cacheSize와 같다면 가장 오래전에 사용한 데이터를 삭제하고 삽입
*/

import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> cache = new ArrayList<>();
        int answer = 0;
        
        loop:
        for(int i = 0; i < cities.length; i++){
            String city = cities[i];
            
            for(int j = 0; j < cache.size(); j++){
                String cacheCity = cache.get(j);
                //캐시에 찾는 데이터가 존재한다면
                if(city.equalsIgnoreCase(cacheCity)){
                    cache.add(cache.remove(j));
                    answer++;
                    continue loop;
                }
            }
            
            cache.add(city);
            
            if(cache.size() == cacheSize + 1){
                cache.remove(0);
            }
            answer += 5;
        }
        return answer;
    }
}