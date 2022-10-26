package kakao.blind_recruitment2018;

import java.util.*;

public class Level2s{
    public static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for(String city : cities){
            city = city.toLowerCase();

            if(cacheSize==0){
                answer+=5;
            }else{
                if(set.size()<cacheSize){
                    if(set.contains(city)){
                        set.remove(city);
                        set.add(city);
                        answer += 1;    
                    }else{
                        set.add(city);
                        answer += 5;    
                    }
                }else{
                    if(set.contains(city)){
                        set.remove(city);
                        set.add(city);
                        answer += 1;
                    }else{
                        removeCache();
                        set.add(city);
                        answer += 5;
                    }
                }
            }
        }

        return answer;
    }

    public static void removeCache(){
        for(String city : set){
            set.remove(city);
            break;
        }
    }


    public static void main(String args[]){
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int result= solution(cacheSize, cities);

        System.out.println(result);
    }
}
