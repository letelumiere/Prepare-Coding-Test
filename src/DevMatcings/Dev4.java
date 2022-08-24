package DevMatcings;

import java.util.LinkedList;
import java.util.Queue;

public class Dev4 {
    //AAAAAA
    //JEROEN
    public int solution2(String name) {
        int answer = 0;
        int length = name.length();

        int index;
        int move = length - 1;

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while(index < length && name.charAt(index) == 'A'){ 
                index++;
            }
            
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }

    public int solution1(String name){
        int answer = 0;
        int length = name.length();
        
        int index;
        int move = length-1;

        for(int i=0;i<name.length();i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            index = i+1;

            while(index<length && name.charAt(index)=='A') {
                index++;
            }

            move = Math.min(move, i*2 + length - index);
            move = Math.min(move, (length-index)*2 + i);
        }
        
        return answer + move;
    }

    public int solution0(String name){
        int length = name.length();
        int idx = 0; 
        int answer = 0;

        char[] data = new char[name.length()];        
        while(!name.equals(String.valueOf(data))){  
            if(name.charAt(idx)!='A') {
                answer += Math.min(name.charAt(idx)-'A', 'Z'-name.charAt(idx)+1);
                data[idx] = name.charAt(idx);
            }

            int n = idx;
            int move = 0;
            while(move<length-1 && name.charAt(n)!='A'){
                if(n!=idx) --n;
                if(n<0) n = length-1;
                ++move;


                if(idx+move<length && name.charAt(idx+move)!='A'){
                    
                    idx = idx+move;
                    break;
                }else if(idx+move>=length && name.charAt(idx+move-(length-1))!='A') {
                    idx = idx+move-(length-1);
                    break;
                }


            }


            answer += move;            
        }





        return answer;
    }


    public static void main(String args[]){
        //JEROEN = 56;
        Dev4 s = new Dev4();
        int result = s.solution0("JEROEN");

        System.out.println(result);
    }
}


/*
    1) 문자열의 idx
    2) 문자열의 기저 조건
        2-1) n = idx<(name.length/2) ? idx : (name.length-idx); idx가 name.length/2 보다 크거나 혹은 작거나 같은지
        2-2) n = name.charAt(idx)<('Z'-'A')/2 ? name.charAt(idx)-'A' : 'Z'-name.charAt(idx);    

 */
