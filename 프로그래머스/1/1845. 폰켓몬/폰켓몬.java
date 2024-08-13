import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        
        if(set.size() >= nums.length / 2)
            return nums.length / 2;
        
        answer = set.size();
        return answer;
    }
}