import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] correct = new int[3];
        int[][] p = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < p.length; j++){
                if(answers[i] == p[j][i % p[j].length])
                    correct[j]++;
            }
        }
        int maxValue = Arrays.stream(correct).max().getAsInt();
        
        ArrayList<Integer> ary = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(correct[i] == maxValue){
                ary.add(i+1);
            }
        }
        
        return ary.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}