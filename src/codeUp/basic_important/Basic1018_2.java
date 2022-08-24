package codeUp.basic_important;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Basic1018_2 {
    public static void main(String args[]){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd , HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        String time = sdf.format(cal.getTime());
        System.out.println(time);
    }
}
