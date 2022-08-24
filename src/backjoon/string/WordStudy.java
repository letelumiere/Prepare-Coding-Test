package backjoon.string;

import java.util.Arrays;
import java.util.HashMap;

public class WordStudy {

    public static char solution(String str){
        HashMap<Character, Integer> hMap = new HashMap<>();
        str = str.toUpperCase();
        char answer = ' ';

        int max = 0;
        for(int i=0;i<str.length();++i){
            hMap.put(str.charAt(i), hMap.getOrDefault(str.charAt(i), 0)+1);
            max = Math.max(hMap.get(str.charAt(i)), max);
        }   
        
        for(char i='A';i<='Z'; i++){
            if(hMap.get(i)!=null && hMap.get(i)<max) hMap.remove(i);
            else if(hMap.get(i)!=null && hMap.get(i)==max) answer = i;
        }

        return hMap.size()==1 ?  answer : '?';
    }

    public static void main(String args[]){
        System.out.println(solution("zZa"));
    }
}
