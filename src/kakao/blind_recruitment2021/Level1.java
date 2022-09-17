package kakao.blind_recruitment2021;

public class Level1 {
    public static String solution(String new_id) {
        char[] array = new_id.toLowerCase().toCharArray();
        String answer = "";

        for(int i=0;i<array.length;i++){
            if((array[i]=='-' || array[i]=='_') || (array[i]>=97 && array[i]<=122) || (array[i]>=48 && array[i]<=57)){
                answer += array[i];
            }
            if(array[i]=='.'){
                if(i<array.length-1 && array[i+1]=='.') continue;
                else answer += array[i];
            }
        }


        if(answer.length()>1){
            while(answer.charAt(0)=='.' || answer.charAt(answer.length()-1)=='.'){
                if(answer.charAt(0)=='.') answer = answer.substring(1);
                if(answer.charAt(answer.length()-1)=='.') answer = answer.substring(0, answer.length()-1);
            }        
        }else{
            answer = "";
        }

        if(answer.length()>=16){
            answer = answer.substring(0, 15);

            while(answer.charAt(answer.length()-1)=='.'){
                answer = answer.substring(0, answer.length()-1);
            }
        }else if(answer.length()<=2){
            if(answer.isEmpty()) answer = "a";

            while(answer.length()<3){
                answer += answer.charAt(answer.length()-1);
            }
        }





        return answer;
    }


    public static void main(String args[]){
        System.out.println(solution(        "...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));


    }
}