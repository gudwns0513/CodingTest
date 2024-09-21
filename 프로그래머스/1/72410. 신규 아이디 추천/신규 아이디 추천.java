class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //3자 이상 15자 이하 확인
        if(new_id.length() < 3 || new_id.length() > 15){
            return changeId(new_id);
        }
        
        //알파벳 소문자, 숫자, -, _, .만 사용한지 확인
        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if(!(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && !(c == '_') && !(c == '-') && !(c == '.')){
                return changeId(new_id);
            }
        }
        
        // .이 시작과 끝에 위치했는지, 연속 되는지 확인
        if(new_id.charAt(0) == '.' || new_id.charAt(new_id.length() - 1) == '.' || new_id.contains("..")){
            return changeId(new_id);
        }
        
        return new_id;
        
    }
    
    //새로운 아이디 추천
    public String changeId(String id){
        
        //1단계
        String step1 = id.toLowerCase();
        
        //2단계
        StringBuilder step2 = new StringBuilder();
        for(int i = 0; i < step1.length(); i++){
            char c = step1.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c == '-') || (c == '_') || (c == '.')){
                step2.append(c);
            }
        }
        
        //3단계
        String step3 = step2.toString().replace("..", ".");
        while(step3.contains("..")){
            step3 = step3.replace("..", ".");
        }
        
        // 4단계
        String step4 = step3;
        if (!step4.isEmpty() && step4.charAt(0) == '.') {
            step4 = step4.substring(1, step4.length());
        }
        if (!step4.isEmpty() && step4.charAt(step4.length() - 1) == '.') {
            step4 = step4.substring(0, step4.length() - 1);
        }
        
        //5단계
        String step5;
        if(step4.length() == 0)
            step5 = "a";
        else{
            step5 = step4;
        }
        
        //6단계
        String step6 = step5;
        if(step6.length() > 15){
            step6 = step6.substring(0, 15);
        }
        if(!step6.isEmpty() && step6.charAt(step6.length() - 1) == '.'){
            step6 = step6.substring(0, step6.length()-1);
        }
        
        //7단계
        StringBuilder step7 = new StringBuilder(step6);
        while(step7.length() < 3){
            step7.append(step7.charAt(step7.length() - 1));
        }
        
        return step7.toString();
        
        
            
    }
}