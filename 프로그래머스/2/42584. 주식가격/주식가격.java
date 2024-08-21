class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        answer[prices.length-1] = 0;
        answer[prices.length-2] = 1;
        
        for(int i = 0; i < prices.length-2; i++){
            
            if(prices[i] > prices[i + 1]) answer[i] = 1;
            else{
                for(int j = i + 1; j < prices.length; j++){
                    answer[i] = j - i;
                    if(prices[i] > prices[j]){
                        break;
                    }
                }
            }
            
        }
        return answer;
    }
}