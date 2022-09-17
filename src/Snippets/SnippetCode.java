package Snippets;

import java.util.Arrays;
import java.util.Comparator;

public class SnippetCode {
    
    //2차원 배열의 comparator 예시
    public void comparator(int[][] schedules){
		Arrays.sort(schedules, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];				
				return o1[1] - o2[1];
			}
		});
    }

    
}
