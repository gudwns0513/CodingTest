import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Stack<Integer>> map = new ArrayList<>(); //인형뽑기 기계
        Stack<Integer> backet = new Stack<>(); //바구니
        map.add(new Stack<>()); //0번 인덱스에 넣어둘 빈 스택
        
        for(int i = 0; i < board.length; i++){ //board -> 스택 변환
            map.add(new Stack<>());
            for(int j = board.length-1; j >= 0; j--){
                if(board[j][i] != 0)
                    map.get(i+1).push(board[j][i]);
            }
        }
        
        for(int move : moves){
            if(map.get(move).isEmpty()) //뽑기 기계가 비어있다면 아무것도 안함
                continue;
            
            int doll = map.get(move).pop(); //뽑은 인형의 숫자
            
            if(backet.isEmpty()) //바구니가 비어있으면 뽑은인형 넣기
                backet.push(doll);
            else{
                if(doll == backet.peek()){//바구니안에 인형과 비교해서 같으면 삭제 아니면 넣기
                backet.pop();
                answer += 2;
                }else{
                    backet.push(doll);
                }
            }
            
                
            
        }
        
        return answer;
    }
}