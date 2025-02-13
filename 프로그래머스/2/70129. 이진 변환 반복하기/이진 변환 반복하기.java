/*
    접근
    1. 0을 모두 삭제(count해서 answer에 저장)
    2. 남은 길이를 2진법으로 표현
    3. 반복
*/
import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int removeZeroCount = 0;
        int toBinaryCount = 0;

        
        StringBuilder str = new StringBuilder(s);
        
        //"1"이 될때까지 진행
        while(!str.toString().equals("1")){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '0'){
                    
                    //0인 부분 삭제
                    str.deleteCharAt(i);
                    
                    //삭제된 0개수 카운트
                    removeZeroCount++;
                    
                    //삭제로 인해 당겨진 인덱스 복귀
                    i--;
                } 
            }
            //2진법 변환
            str = new StringBuilder(toBinary(str.length()));
            
            //2진법 변환 횟수 카운트
            toBinaryCount++;
            
        }
        
        answer = new int[] {toBinaryCount, removeZeroCount};
        
        return answer;
    }
    
    
    //숫자 -> 이진법 변환 함수
    public String toBinary(int length){
        Stack<Integer> stack = new Stack<>();
        
        while(length > 0){
            stack.push(length % 2);
            length /= 2;
        }
        
        StringBuilder str = new StringBuilder();
        
        while(!stack.isEmpty()) str.append(stack.pop());
        
        return str.toString();
        
        
    }
}