package practice;

import java.util.*;

import java.util.*;
class Solution {
    class Member{
        int idx;
        String node;
        String parents;

        Member(int idx, String node, String parents){
            this.idx = idx;
            this.node = node;
            this.parents = parents;
        }
    }

    public int[] solution2(String[] enroll, String[] referral, String[] seller, int[] amount){
        HashMap<String, Member> hMap = new HashMap<>();
        int[] answer = new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            hMap.put(enroll[i], new Member(i, enroll[i], referral[i]));
        }

        for(int i=0;i<enroll.length;i++){
            Member m = hMap.get(seller[i]);
            int profit = amount[i]*100;

            while(!m.node.equals("-")){
                if(profit<1) break;

                answer[m.idx] += profit-(profit/10);
                profit = profit/10;

                if(m.parents.equals("-"))break;
                m = hMap.get(m.parents);
            }
        }

        return answer;
    }


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        HashMap<String, Member> hMap = new HashMap<>();
        int[] answer = new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            hMap.put(enroll[i], new Member(i, enroll[i], referral[i]));
        }

        for(int i=0;i<seller.length;i++){
            Member m = hMap.get(seller[i]);
            int profit = amount[i]*100;

            while(!m.node.equals("-")){
                if(profit<1) break;

                answer[m.idx] += (profit - (profit/10));
                profit = profit/10;

                if(m.parents.equals("-"))break;
                m = hMap.get(m.parents);
            }
        }



        return answer;
    }
}