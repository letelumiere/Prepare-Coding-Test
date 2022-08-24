package programmers.montlyCode;

import java.util.HashMap;

public class Question11 {
    public static int solution(String s) {
        HashMap<String, Integer> hMap = new HashMap<>();
        int answer = 0;
        String word = "";
        String temp = "";

        hMap.put("zero", 0);
        hMap.put("one", 1);
        hMap.put("two", 2);
        hMap.put("three", 3);
        hMap.put("four", 4);
        hMap.put("five", 5);
        hMap.put("six", 6);
        hMap.put("seven", 7);
        hMap.put("eight", 8);
        hMap.put("nine", 9);

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

    public static void main(String args[]){
        int result = solution("one4seveneight"	);

        System.out.println(result);
    }
}
