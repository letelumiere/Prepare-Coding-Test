package codeUp.basic_important;

import java.util.Arrays;
import java.util.stream.Stream;

public class Basic1025_important {
    public static void main(String args[]){
        int number = 12345;
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        System.out.print( Arrays.toString(digits) ); // [1, 2, 3, 4, 5]
    }

    public void temp(){
        int n = 23363;
    }
}
