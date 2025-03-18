import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lotto = Arrays.stream(lottos)
            .boxed()
            .collect(Collectors.toList());

        List<Integer> win_num = Arrays.stream(win_nums)
            .boxed()
            .collect(Collectors.toList());

        int max = 0;
        int min = 0;
        for(int i = 0; i < lotto.size(); i++){
            if(lotto.get(i) == 0){
                max++;
            }

            if(win_num.contains(lotto.get(i))){
                max++;
                min++;
            }
        }

        if(min == 0) min = 1;

        if(max == 0) max = 1;

        int[] answer = {7-max, 7-min};

        return answer;        
    }
}