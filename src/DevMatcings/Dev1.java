package DevMatcings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//한나절 걸림
//이제부터 분석 좀 하자
//greedy algorithm으로 풀었음
//

public class Dev1 {
    static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    static String[] seller = {"young", "john", "tod", "emily", "mary"};
    static int[] amount = {12, 4, 2, 5, 10};
//    int[] result = {360, 958, 108, 0, 450, 18, 180, 1080};

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> hMap = new HashMap<>();

        for(int i=0;i<enroll.length;i++){
            hMap.put(enroll[i], i);
        }

        for(int i=0;i<seller.length;i++){
            int n = hMap.get(seller[i]);
            int profit = amount[i]*100;
            int margin = Math.round(profit*10)/100;

            answer[n] += (profit - margin);
            if(!referral[n].equals("-")) {
                int k = hMap.get(referral[n]);
                marginCheck(hMap, answer, referral[k], referral, k, margin);
            }
        }
        return answer;
    }

    
    public void marginCheck(HashMap<String, Integer> hMap, int[] answer, String eName, String[] referral, int n, int margin){
        int margin2 = Math.round(margin*10)/100;

        if(margin<0){
            answer[n] += margin;
            return;
        }else{
            answer[n] += margin - margin2;

            if(referral[n].equals("-")){
                return;
            }else{
                if(!eName.equals("-")){
                    int k = hMap.get(eName);
                    marginCheck(hMap, answer, referral[k], referral, k, margin2);            
                }
            }
        }
    }


    public static void main(String args[]){
        Dev1 s = new Dev1();
        int[] result = s.solution(enroll, referral, seller, amount);

        for(int i=0;i<result.length;i++){
            System.out.println(enroll[i]+" "+result[i]);
        }

    }
}



/*
 * 
 * 
 * 
 *String[] enroll = ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	
 *String[] referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	
 *String[] seller = ["young", "john", "tod", "emily", "mary"]
 *int[] amount = [12, 4, 2, 5, 10]
 *int[] result = [360, 958, 108, 0, 450, 18, 180, 1080]
 */