package codeUp.basic_important;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Basic1018 {
    public static void main(String args[]){

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy / MM / dd / HH:mm:ss");

        Date time = new Date();

        String time1 = format1.format(time);
        String time2 = format2.format(time);
    
        System.out.println(time1);
        System.out.println(time2);
    }
}
