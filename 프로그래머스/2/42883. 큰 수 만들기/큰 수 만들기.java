/*
    - 접근
    1. 맨 앞부터 2자리 수 비교 후 앞자리가 작으면 삭제
    2. 넘어가면서 계속 삭제
*/
import java.lang.*;
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        for(int i = 0; i < number.length() - k; i++){
            char max = 0;
            for(int j = index; j <= i + k; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            sb.append(max);
            
        }
        
        return sb.toString();
    }
}