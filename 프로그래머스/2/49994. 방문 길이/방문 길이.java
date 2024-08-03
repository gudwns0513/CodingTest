import java.util.*;
class Solution {
    int answer = 0;
    public int solution(String dirs) {
        int x = 5;
        int y = 5;
        int nx = 0;
        int ny = 0;
        HashSet<String> answer = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++){
            
            if(dirs.charAt(i) == 'L'){
                nx = x;
                ny = y-1;
            }
            else if(dirs.charAt(i) == 'R'){
                nx = x;
                ny = y+1;
            }
            else if(dirs.charAt(i) == 'U'){
                nx = x-1;
                ny = y;
            }
            else if(dirs.charAt(i) == 'D'){
                nx = x+1;
                ny = y;
            }
            
            
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10){
                continue;
            }else{
                answer.add(x + "" + y + "" + nx + "" + ny);
                answer.add(nx + "" + ny + "" + x + "" + y);
                x = nx;
                y = ny;
            }
            
        }
        
        return answer.size() / 2;
    }
}