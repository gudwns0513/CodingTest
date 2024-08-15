class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int length = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] > width)
                width = sizes[i][0];
            
            if(sizes[i][1] > length)
                length = sizes[i][1];
        }
        
        answer = width * length;
        
        
        
        return answer;
    }
}