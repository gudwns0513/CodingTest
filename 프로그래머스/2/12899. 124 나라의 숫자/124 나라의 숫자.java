class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] num = {4, 1, 2};
        
        while(n > 0) {
            int merge = n % 3;
            n /= 3;
            
            if(merge == 0) n--;
            
            // num[merge] 값을 문자열로 이어 붙임
            answer.insert(0, num[merge]);
        }
        
        return answer.toString();
    }
}
