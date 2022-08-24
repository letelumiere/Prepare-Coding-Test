package codeUp.basic_important;


import java.text.SimpleDateFormat;

public class Basic1018_3 {
    public static void main(String args[]){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String format_time = sdf.format(System.currentTimeMillis());

        System.out.println(format_time);

    }
}
