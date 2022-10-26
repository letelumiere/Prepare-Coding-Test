package kakao.blind_recruitment2018;

public class Level1_secretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0;i<n;i++){
            String binary1 = String.format("%0"+n+"d",Integer.parseInt(Integer.toBinaryString(arr1[i])));
            String binary2 = String.format("%0"+n+"d",Integer.parseInt(Integer.toBinaryString(arr2[i])));

            for(int j=0;j<n;j++){
                if(answer[j]==null) answer[j]="";

                if(binary1.charAt(j)=='1' || binary2.charAt(j)=='1') answer[i] += "#"; 
                else if(binary1.charAt(j)=='0' && binary2.charAt(j)=='0') answer[i] += " ";
            }
        }
        return answer;
    }

    public static void main(String args[]){
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = solution(5, arr1, arr2);

        for(int i=0;i<result.length;i++){
            System.out.println(i+" "+result[i]);
        }
    }
}
