class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i = 1; i <= yellow; i++){
            int yellowWidth = i;
            if(yellow % i != 0) continue;
            int yellowHeight = yellow / i;
            int comBrown = (yellowWidth * 2) + (yellowHeight * 2) + 4;
            
            if(brown == comBrown){
                answer = new int[] {yellowWidth + 2, yellowHeight + 2};
            }
        }
        return answer;
    }
}