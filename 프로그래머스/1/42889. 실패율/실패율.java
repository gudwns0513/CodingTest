import java.util.HashMap;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] fail = new int[N+2]; //인덱스=스테이지번호, 값=실패한 사람
        for(int i = 0; i < stages.length; i++){
            fail[stages[i]] += 1;
        }
        
        double total = stages.length; //N이 1이상이므로 1스테이지는 모두가 도달해봤기 때문
        
        HashMap<Integer, Double> stageAndFailRate = new HashMap<>(); //키:스테이지, 값:실패율
        
        for(int i = 1; i < N+1; i++){
            double failRate;
            if(fail[i] == 0)
                failRate = 0.0;
            else{
                failRate = fail[i] / total;
            }
            stageAndFailRate.put(i, failRate);
            total -= fail[i];//ex) 2스테이지 도달자 = 전체 스테이지 도달자 - 1스테이지 도달자
        }
        
        return stageAndFailRate.entrySet().stream()
            .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
            .mapToInt(HashMap.Entry::getKey)
            .toArray();
    }
}