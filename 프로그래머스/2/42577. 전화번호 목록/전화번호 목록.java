import java.util.*;
import java.lang.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
    
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(int j = 0; j < phone_book.length; j++){
            for(int k = 0; k < phone_book[j].length(); k++){
                if(set.contains(phone_book[j].substring(0, k)))
                    return false;
            }
        }
            
        return answer;
    }
}