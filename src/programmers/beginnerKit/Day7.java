package programmers.beginnerKit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day7 {
    public int solution7_protractor(int angle) {
        int answer = 0;
        if(0<=angle && angle<90) answer =1;
        if(angle==90) answer = 2;
        if(90<angle && angle<180) answer = 3;
        if(angle<180) answer = 4;
        return answer;
    }

    public int solution7_sumOfEven(int n) {
        int answer = 0;
        for(int i=0;i<=n;i++){
            if(i%2==0) answer+=i;
        }
        return answer;
    }

    public int solution7_lambKkochi(int n, int k) {
        return (n*12000)+((k-(n/10))*2000);
    }

    public String solution7_eraseSpecificLetter(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }

    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = {};
        return answer;
    }
    public int solution(int[] dot) {
        int answer = 0;
        int x = dot[0];
        int y = dot[1];

        if(0<=x && 0<=y) answer = 1;
        if(x<0 && 0<=y) answer = 2;
        if(x<0 && y<0) answer = 3;
        if(0<=x && y<0) answer = 4;
        return answer;
    }

    public String solution_vowel_remove(String my_string) {
        String answer = my_string.replaceAll("[aeiou]", "");
        return answer;
    }

    public int[] solution_evenand(int[] num_list) {
        int[] answer = new int[2];
        for(int i : num_list){
            if(i%2==0) ++answer[0];
            else ++answer[1];
        }

        return answer;
    }

    public int solution_discount(int price) {
        if(500000<= price) return (int)Math.floor(price*0.8);
        if(300000<=price && price<500000) return price = (int)Math.floor(price*0.9);
        if(100000<=price && price<300000) return price = (int)Math.floor(price*0.95);        
        return price;
    }

    public int[] solution_iceAmericano(int money) {
        int[] answer = {money/5500, money%5500};
        return answer;
    }

    public int[] solution_arrayDataLength(String[] strlist) {
        int[] answer = new int[strlist.length];

        for(int i=0;i<answer.length;i++){
            answer[i] = strlist[i].length();
        }

        return answer;
    }

    public int[] solution_arraySlice(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }

    public String solution_StringRepeat(String my_string, int n) {
        StringBuffer answer = new StringBuffer();
        for(int i=0;i<my_string.length();i++){
            for(int j=0;j<n;j++){
                answer.append(my_string.charAt(i));
            }
        }

        return answer.toString();
    }

    //직각삼각형 출력하기 문제    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.println("*".repeat(i));
        }

        System.out.println(n);
    }

    public String solution_RockScissorPaper(String rsp) {
        StringBuffer answer = new StringBuffer();

        for(int i=0;i<rsp.length();i++){
            if(rsp.charAt(i)=='2') answer.append('0');
            else if(rsp.charAt(i)=='0') answer.append('5');
            else if(rsp.charAt(i)=='5') answer.append('2');
            
        }
        return answer.toString();
    }
    
}
