/*
    
*/

class Solution {
    public int[] solution(int n) {
        int[][] tower = new int[n][n];
        int max = (n*(n+1)) / 2; //1~n까지의 합
        int[] answer = new int[max];
        
        int x = -1;
        int y = 0;
        int num = 0;
        
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    tower[++x][y] = ++num;
                }else if(i % 3 == 1){
                    tower[x][++y] = ++num;
                }else{
                    tower[--x][--y] = ++num;
                } 
            } 
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                answer[count++] = tower[i][j];
            }
        }
        
        
        
        
        return answer;
    }
}