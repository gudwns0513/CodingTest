class Solution {
    static int count = 0;
    static int[] ary;
    static int tar;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        ary = numbers;
        tar = target;
        dfs(0);
            
        return answer;
    }
    
    static void dfs(int depth){
        if(depth == ary.length){
            int sum = 0;
            for(int i = 0; i < ary.length; i++){
                sum += ary[i];
            }
            if(sum == tar)
                answer++;
            return;
        }
        
        for(int j = 0; j < 2; j++){
            ary[depth] = ary[depth] * -1;
            dfs(depth + 1);
        }
    }
}