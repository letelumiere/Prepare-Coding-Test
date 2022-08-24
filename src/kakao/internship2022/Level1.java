package kakao.internship2022;

import java.util.*;

public class Level1 {
    public static int solution(String s) {
        HashMap<String, Integer> hMap = new HashMap<>();
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int answer = 0;

        for(int i=0;i<number.length;i++){
            hMap.put(number[i], i);
        }
        
        String word = "";
        String temp = "";
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57) word += s.charAt(i);
            else{
                temp += s.charAt(i);
                if(hMap.get(temp)!=null){
                    word += hMap.get(temp);
                    temp = "";
                }
            }
        }
        return answer = Integer.parseInt(word);
    }
}
