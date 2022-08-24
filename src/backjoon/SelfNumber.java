package backjoon;

public class SelfNumber {
    static int[] array;
    //d(75) = 75+7+5 = 87이다.
    //d(101) = 91 + 9 + 1
    //d(101) = 100+ 0 + 1
    //n==d(n);
    //75=d(75)=87
    
    public static int selfNumber(int n){
        int k = n;
        while(n!=0){
            k += n%10;
            n /= 10;
        }
        return n+k; 
    }

    public static int constructor(int n){
        

        return n;
    }

    //n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 
    //constructor(n) = 33, d(n) = 39
    //constructor(n) = 39, d(n) = 51
    //constructor(n) = 51, d(n) = 57
    
    //생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. 
    public static int d(int n){
        int k = n;
        while(n!=0){
            k += n%10;
            n /= 10;
        }
        return n;        
    }


    public static int solution(int answer){
        return answer;
    }
    public static void main(String args[]){
        array = new int[10000];

    
        for(int i=1;i<array.length;i++){
//            System.out.println(selfNumber(i));
        }
    }

}

