package backjoon.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Croatian_Alphabet {
    static String alphabet1 = "(c=)|(c-)|(d-)|(lj)|(nj)|(s=)|(z=)";
    static String alphabet2 = "(dz=)";
    
    public static int solution(String str){
        int answer = 0;

        while(str.length()>0){
            if(str.length()>=3 && str.substring(0, 3).matches(alphabet2)){
                str = str.substring(3);
            }else if(str.length()>=2 && str.substring(0, 2).matches(alphabet1)){
                str = str.substring(2);
            }else{
                str = str.substring(1);
            }
            answer++;
        }

        return answer;
    }
    

    public static int solution2(String str){
        int answer = 0;
        str = str.replaceAll("(c=)|(c-)|(d-)|(dz=)|(lj)|(nj)|(s=)|(z=)", "a");

        return answer = str.length();
    }


    public static void main(String args[]){
        System.out.println(solution2("ljes=njak")); //6
        System.out.println(solution2("ddz=z=")); //3
        System.out.println(solution2("nljj"));  //3
        System.out.println(solution2("c=c="));  //2
        System.out.println(solution2("dz=ak")); //3
    }
}
