class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, computers);
            }
                
        }
        return answer;
    }
    
    public void dfs(int network, int[][] computers){
        if(visited[network]){ //재귀함수 조건문
           return;
        }
        
        visited[network] = true; //방문 기록
        
        for(int i = 0; i < computers.length; i++){//조건 만족하는 연결 네트워크 모두 방문
            if(computers[network][i] == 1){
                dfs(i, computers);
            }
        }
        
        
    }
}