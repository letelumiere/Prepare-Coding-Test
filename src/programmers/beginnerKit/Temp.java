package programmers.beginnerKit;
import java.math.BigInteger;
import java.util.*;

public class Temp {
    public int solution_arrayMaxMultiply(int[] numbers) {
        int n = numbers.length-1;
        int answer = numbers[n]*numbers[n-1];
        return answer;
    }


    public int[] solution_arraySort(String my_string) {
        my_string = my_string.replaceAll("[^0-9$]", "");
        int[] answer = new int[my_string.length()];

        for(int i=0;i<my_string.length();i++){  
            answer[i] = Character.getNumericValue(my_string.charAt(i));
        }
        
        Arrays.sort(answer);
        return answer;
    }

    public int solution_antLegion(int hp) {
        return (hp/5)+(hp%5)/3+((hp%5)/3)%3;
    }
    public int solution_antLegion1(int hp) {
        int answer = hp / 5;
        hp %= 5;

        answer += hp / 3;
        hp %= 3;

        answer += hp / 1;
        return answer;
    }
    public int solution_antLegion2(int hp) {
        int answer = 0;
        while(hp > 0) {
            if(hp >= 5) {
                answer++;
                hp -= 5;
            } else if(hp >= 3) {
                answer++;
                hp -= 3;
            } else {
                answer++;
                hp -= 1;
            }
        }
        return answer;
    }

    public int solution_hideNumbersSum(String my_string) {
        int answer = 0;

        my_string = my_string.replaceAll("[^0-9$]", "");
        for(int i=0;i<my_string.length();i++){
            answer += Character.getNumericValue(my_string.charAt(i));
        }

        return answer;
    }

    public int euclid(int a, int b, int result){
        if(b==0) return result;
        return a>b ? euclid(b, b/2, ++result) : euclid(a, a%b, ++result);
    }

    public String xeno_translation(int age) {
        StringBuffer answer = new StringBuffer();
        char[] chArr = Integer.toString(age).toCharArray();

        for(int i=0;i<chArr.length;i++){
            answer.append((char)(chArr[i]+49));
        }
        return answer.toString();
    }

    public int[][] to2Char1(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        
        for(int i=0, k=0;i<num_list.length;i+=n, k++){
            answer[k] = Arrays.copyOfRange(num_list, i, i+n);
        }
        
        return answer;
    }
    
    public int solution_findhapseungsu(int n) {
        int answer = 0;
        while(n>0){
            if(isPrime(n)) ++answer;
            --n;
        }
        return answer;
    }
    
    public boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return true;
        }
        return false;
    }

    public int solution_cutPaper(int M, int N) {
        return M*N-1;
    }

    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);

        for(int i=0;i<chArr.length;i++){
            int n = 0;
            for(int j=0;j<chArr.length;j++){
                if(i!=j) answer.append(chArr[j]);
            }
        }

        return answer.toString();
    }

    public String solution_morse(String letter) {
        String answer = "";
        return answer;
    }
    
    public String solution_binarySum(String bin1, String bin2) {
        BigInteger b1 = new BigInteger(bin1, 2);
        BigInteger b2 = new BigInteger(bin2, 2);
        b1 = b1.add(b2);
        int answer = b1.intValue();
        
        return Integer.toBinaryString(answer);
    }

    public int solution_ball(int[] numbers, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for(int i : numbers) queue.offer(i);
        
        int n = 0;
        while(n<=k){
            for(int i=1;i<=2;i++) queue.offer(queue.poll());
            answer = queue.peek();
            ++n;
        }
        return answer;
    }

    public int solution_xeno_dic(String[] spell, String[] dic) {
        int answer = 0;
        Arrays.sort(spell);

        StringBuffer sb = new StringBuffer();        
        for(String s : spell){
            sb.append(s);
        }
    
        for(String s : dic){
            char[] chArr = s.toCharArray();
            String sorted = String.valueOf(chArr);

            sorted = sorted.replaceAll(sb.toString(), "");
            
            if(sorted.length()==0) ++answer;
        }


        return answer;
    }


    public int[] solution_tortureNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        while(n>1){
            for(int i=2;i<=n;i++){
                if(n%i==0){
                    set.add(i);
                    n /= i;
                    break;
                }
            }   
        }

        int[] answer = Arrays.stream(set.toArray(new Integer[0])).mapToInt(i -> i).toArray();
        return answer;
    }

    public int solution_marvel(int balls, int share) {
        int answer = 0;
        return answer;
    }

    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i=0;i<emergency.length;i++){
            answer[i] = 1;
            for(int j=0;j<emergency.length;j++){
                if(i!=j && emergency[i]<emergency[j]) ++answer[i];
            }
        }
        
        return answer;
    }
    
    public int solution_hide(String my_string) {
        int answer = 0;
        my_string = my_string.replaceAll("\\D", " ");
        
        String[] strArr = my_string.split(" ");
        for(int i=0;i<strArr.length;i++){
            answer += Integer.parseInt(strArr[i]);
        }
        
        return answer;
    }
    
    public int solution_decha(int[] common) {       
//        if(common[1]-common[0] == common[2]-common[1]) answer = common[1] - common[0];
//       if(common[1]/common[0] == common[2]/common[1]) answer = common[1] / common[0];

        
        return common[1]-common[0] == common[2]-common[1] ? common[common.length-1] + common[1]-common[0] 
                                                            : common[common.length-1] * common[1]/common[0];
    }

    public int solution_yuhan(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        int gcd = b1.gcd(b2).intValue();
        
        a /= gcd;
        b /= gcd;

        return b==2 || b==5 || b==2*5 ? 1 : 0;
    }

    public int solution_ctrlZ(String s) {
        int answer = 0;
        String[] strArr = s.split("\\s");

        for(int i=0;i<strArr.length;i++){            
            if(strArr[i].equals("Z")) answer -= Integer.parseInt(strArr[i-1]);
            else answer += Integer.parseInt(strArr[i]);
        }
        return answer;
    }

    public int solution_ctrlZ2(String s) {
        Stack<String> stack = new Stack();
        int answer = 0;
        
        String[] strArr = s.split("\\s");
                
        for(String str : strArr){
            if(str.equals("Z")) stack.pop();
            else stack.push(str);
        }
        
        while(!stack.isEmpty()){
            answer += Integer.parseInt(stack.pop());
        }        
        return answer;
    }


    public int[] solution_position(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        for(int i=0;i<keyinput.length;i++){

        }


        return answer;
    }

    public int solution_ongoal(String[] babbling) {
        int answer = 0;

        for(int i=0;i<babbling.length;i++){ 
            if(babbling[i].contains("aya"))++answer;
            if(babbling[i].contains("ye"))++answer;
            if(babbling[i].contains("woo"))++answer;
            if(babbling[i].contains("ma"))++answer;
        }

        return answer;
    }

    class LandMine{
        int x;
        int y;
        public LandMine(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }

    public int solution22(int[][] board) {
        ArrayList<LandMine> alist = new ArrayList<>();
        
        int n = board.length;
        int answer = n*n;
        int[][] range = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==1) {
                    alist.add(new LandMine(i,j));
                    --answer;
                }
            }
        }

        for(LandMine mine : alist){
            for(int k=0;k<range.length;k++){
                int x = mine.x+range[k][0];
                int y = mine.y+range[k][1];

                if((0<=x && x<board.length && 0<=y && y<board.length)){
                    if(board[x][y]==0) board[x][y] = 1;
                    --answer;
                }
            }    
        }        
        
        return answer > 0 ? answer : 0;
    }
    

    public int solution_3(int n) {
        int answer = 0;

        for(int i=1;i<=n;i++){
            ++answer;
            
            while(answer%3==0 || Integer.toString(answer).contains("3")){
                ++answer;
            }
        }
        
        return answer;
    }

    public int[] solution_combo3(int num, int total) {
        int[] answer = new int[num];
        for(int i=-total;i<=total;i++){

            int n = 0;
            for(int j=i;j<answer.length;j++){
                ++answer[j];
                n += answer[j];
            } 
            
            if(n==num) break;
            
        }
        
        Arrays.sort(answer);
        return answer;
    }

    public String[] solution_OX(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0;i<quiz.length;i++){
            String[] str = quiz[i].split("\\=");
            String[] numbers = str[0].split("\\s");
            str[1] = str[1].replaceAll("\\s", "");
            
            int correct = Integer.parseInt(str[1]);
            int result = 0;
            
            if(numbers[1].equals("+")) result = Integer.parseInt(numbers[0])+Integer.parseInt(numbers[2]);
            else if(numbers[1].equals("-")) result = Integer.parseInt(numbers[0])-Integer.parseInt(numbers[2]);
            
            if(result==correct) answer[i] = "O";
            else answer[i] = "X";
        }


        return answer;              
   }

    public static void main(String args){
        Temp s = new Temp();
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        s.solution_OX(quiz);
    }


}