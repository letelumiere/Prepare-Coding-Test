package codeUp.basic_important;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Basic1018_1 {
    public static void main(String args[]){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd , HH:mm:ss");

        Date date = new Date();

        String time = sdf.format(date);

        System.out.println(time);
    }
}
