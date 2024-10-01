/*
    틱택토 게임이 정상적이지 않은 상황
    1. O와 X모두 모두 승리조건을 만족하고 있는 상황
    2. X의 갯수가 O보다 많은 상황
    3. O의 갯수가 X의 갯수보다 2개 이상 많은 상황
*/
import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int x = 0;
        int o = 0;
        
        //2번, 3번 체크
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'O') o++;
                else if(board[i].charAt(j) == 'X') x++;
            }
        }
        //2번
        if(x > o) return 0;

        //3번
        if(o > x + 1) return 0;
        
        
        boolean oCheck = false;
        boolean xCheck = false;
        //가로 3줄 체크
        for(int i = 0; i < 3; i++){
            if(board[i].equals("OOO")) oCheck = true;
            else if(board[i].equals("XXX")) xCheck = true;
        }
        
        //세로 3줄 체크
        for(int i = 0; i < 3; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < 3; j++){
                str.append(board[j].charAt(i));
            }
            
            if(str.toString().equals("OOO")) oCheck = true;
            else if(str.toString().equals("XXX")) xCheck = true;
        }
    
        //대각선 2줄 체크
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(int i = 0; i < 3; i++){
            str1.append(board[i].charAt(i));
            str2.append(board[2-i].charAt(i));
        }
        if(str1.toString().equals("OOO") || str2.toString().equals("OOO")) oCheck = true;
        else if(str1.toString().equals("XXX") || str2.toString().equals("XXX")) xCheck = true;

        // O와 X가 동시에 승리한 경우
        if (oCheck && xCheck) return 0;
        
        // O가 이긴 경우 O의 갯수는 X보다 정확히 1개 많아야 함
        if (oCheck && o != x + 1) return 0;
        
        // X가 이긴 경우 X와 O의 갯수가 같아야 함
        if (xCheck && x != o) return 0;
        
        
        return answer;
    }
}