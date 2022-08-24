package backjoon;

import java.util.Scanner;

public class WordChecker {
    public static int solution(String[] array){
        int answer = 0;
        for(int i=0;i<array.length;i++){
            if(check(array[i])) answer++;
        }

        return answer;
    }

    public static boolean check(String word){
        String str = "";
        boolean result = true;

        for(int i=0;i<word.length();i++){
            String letter = Integer.toString(word.charAt(i));

            if(i!=0){
                if(word.charAt(i)==word.charAt(i-1)) continue;
                else{
                    if(word.charAt(i)!=word.charAt(i-1) && (str.contains(letter))) return false;
                    else str += letter;
                }
            }else str += letter;
        }
        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] array = new String[sc.nextInt()];

        for(int i=0;i<array.length;i++){
            array[i] = sc.nextLine();
        }
        System.out.println(solution(array));
    }
}
