import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        //장르 별 총 재생 횟수
        HashMap<String, Integer> num = new HashMap<>();
        
        //장르에 속하는 노래 및 노래 별 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            if(!music.containsKey(genres[i])){   
                //music에 장르 및 노래 및 재생횟수 추가
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
            }else{
                music.get(genres[i]).put(i, plays[i]);
            }
            //장르 별 총 재생 횟수 추가
            num.put(genres[i], num.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(num.keySet());
        Collections.sort(keySet, (e1, e2) -> num.get(e2).compareTo(num.get(e1)));
        
        System.out.print(music);
        for(int i = 0; i < music.size(); i++){
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(music.get(keySet.get(i)).entrySet());
            Collections.sort(list, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            
            
            //장르 내의 노래가 1개라면
            if(list.size() < 2){
                answer.add(list.get(0).getKey());
                continue;
            }
            
            answer.add(list.get(0).getKey());
            answer.add(list.get(1).getKey());
            
            
        }
    
        

        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}