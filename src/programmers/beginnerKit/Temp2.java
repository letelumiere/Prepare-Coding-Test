package programmers.beginnerKit;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Temp2 {
    class Player {
        int x;
        int y;
        
        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public long solution(long balls, long share) {
        BigInteger answer = 0;
        BigInteger a = BigInteger.valueOf(factorial(balls));
        BigInteger b = BigInteger.valueOf(factorial(balls-share)*factorial(share));
         
        
        return answer = a/b;
    }
    
    public long factorial(long n){
        if(n==1) return n;
        else return n*factorial(n-1);
    }
    public int[] solution(String[] keyinput, int[] board) {
        int limit_x = board[0]/2;
        int limit_y = board[1]/2;

        int[] answer = new int[2];
        Player pc = new Player(0, 0);
    
        
        for(int i=0;i<keyinput.length;i++){
            if(pc.y<limit_y && keyinput[i].equals("up")) ++pc.y;
            if(pc.y>-limit_y && keyinput[i].equals("down")) --pc.y;
            if(pc.x>-limit_x && keyinput[i].equals("left")) --pc.x;
            if(pc.x<limit_x && keyinput[i].equals("right")) ++pc.x;
        }

        answer[0] = pc.x;
        answer[1] = pc.y;
        return answer;
    }

    public int[] solution_rotateArray(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        Queue<Integer> queue = new LinkedList();
        if(direction.equals("left")){
            queue.offer(numbers[numbers.length]);
            
            for(int i=0;i<numbers.length-1;i++){
                queue.offer(numbers[i]);
            }
        }else if(direction.equals("right")){
            for(int i=1;i<numbers.length;i++){
                queue.offer(numbers[i]);
            }
            
            queue.offer(numbers[0]);
        }

        for(int i=0;i<answer.length;i++){
            answer[i] = queue.poll();
        }

        return answer;
    }


    public int solution_diceQty(int[] box, int n) {
        int answer = (box[0]/n) * (box[1]/n) * (box[2]/n);
        return answer;
    }


    public int solution_soonseo(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(n%i==0) ++answer;
        }
    
        return answer;
    }

    public String solution_morse(String letter) {
        String[] letters = letter.split("\\s");
        StringBuffer answer = new StringBuffer();

        String[] morse = { 
            ".-:a","-...:b","-.-.:c","-..:d",".:e","..-.:f","--.:g",
            "....:h","..:i",".---:j","-.-:k",".-..:l","--:m","-.:n",
            "---:o",".--.:p","--.-:q",".-.:r","...:s","-:t","..-:u",
            "...-:v",".--:w","-..-:x","-.--:y","--..:z"
        };

        HashMap<String, String> hMap = new HashMap();
        for(String s : morse){
            String[] signal = s.split("\\:");
            hMap.put(signal[0], signal[1]);
        }

        for(String s : letters){
            answer.append(hMap.get(s));
        }

        return answer.toString();
    }

    public int solution_factorial(int n) {
        int answer = 0;
        int k = 1;
        
        while(k<=n){
            ++answer;
            k *= answer;
        } 

        return k<=n ? answer : answer-1;
    }   

    public int solution_hideString(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("[a-z][A-Z]", " ");

        return answer;
    }

    public int solution_marble(int balls, int share) {
        int answer = 0;
        return answer;
    }

    public int solution(String[] babbling) {
        int answer = 0;

        for(int i=0;i<babbling.length;i++){
            String re1 = "(aya|ye|woo|ma)\1+";
            String re2 = "^(aya|ye|woo|ma)+$";

            if(babbling[i].contains(re1) && babbling[i].contains(re2)) ++answer;

        }
        return answer;

    }


    class Light {
        int start;
        int end;
        public Light(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public int solution_line(int[][] lines) {
        int answer = 0;
        
        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                else return o1[0]-o2[0];
            }
        });

        for(int[] i : lines) Arrays.sort(i);

        for(int i=0;i<lines.length;i++){

        }
    


        return answer;
    }

    public String solution_poly(String polynomial) {
        String[] str = polynomial.split("[+]");
        String answer = "";
        int x = 0;
        int n = 0;

        for(int i=0;i<str.length;i++){            
            str[i] = str[i].replaceAll("\\s","").trim();

            if(str[i].matches("[0-9]+")) n += Integer.parseInt(str[i]);
            if(str[i].equals("x")) x += Integer.parseInt(str[i]);
            if(str[i].matches("[0-9\\w]")) x += Integer.parseInt(str[i].replaceAll("x",""));
        }  

        StringBuffer sb = new StringBuffer();
        sb.is

        if(n>0) {
            answer = Integer.toString(x)+"+"+" "+Integer.toString(n);
        }else{
            answer = Integer.toString(n);
        }

        return answer;
    }
}
