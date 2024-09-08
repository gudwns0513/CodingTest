import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> strs1 = new ArrayList<>(); //다중집합A
        ArrayList<String> strs2 = new ArrayList<>(); //다중집합B

        for(int i = 0; i < str1.length() - 1; i++){
            //대문자 알파벳이 아닌 애가 있으면 빈 문자열로 만들기
            String element = str1.substring(i, i+2).replaceAll("[^A-Z]", "");

            if(element.length() < 2){
                continue;
            }
            strs1.add(element);
        }

        for(int i = 0; i < str2.length() - 1; i++){
            //대문자 알파벳이 아닌 애가 있으면 빈 문자열로 만들기
            String element = str2.substring(i, i+2).replaceAll("[^A-Z]", "");

            if(element.length() < 2){
                continue;
            }
            strs2.add(element);
        }

        if(strs1.size() == 0 && strs2.size() == 0)
            return 65536;

        ArrayList<String> intersection = new ArrayList<>(); //교집합
        ArrayList<String> union = new ArrayList<>(); //합집합

        for(String s : strs1){
            if(strs2.remove(s)){
                intersection.add(s);
            }

            union.add(s);
        }

        union.addAll(strs2);

        double jacard = (double)intersection.size() / (double)union.size() * 65536;


        return (int)jacard;
    }
}