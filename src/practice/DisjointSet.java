package practice;
import java.util.Arrays;


//참조 https://sskl660.tistory.com/71?category=845232

public class DisjointSet {
	public static void main(String[] args) {
		int[] parent = MakeSet(5);
		// 각 인덱스(=노드)는 자기 자신을 가리키고 있다
		System.out.println(Arrays.toString(parent));

		union(parent, 1, 2);
		System.out.println(Arrays.toString(parent));
		union(parent, 2, 3);
		System.out.println(Arrays.toString(parent));
		union(parent, 4, 5);
		System.out.println(Arrays.toString(parent));
		union(parent, 3, 5);
		System.out.println(Arrays.toString(parent));
		System.out.println(find(parent, 1));
		System.out.println(find(parent, 2));
		System.out.println(find(parent, 3));
		System.out.println(find(parent, 4));
		System.out.println(find(parent, 5));
	}

	//자기 자신을 선언하여 자신이 속한 집합이 됨. makeSet()
	private static int[] MakeSet(int size) {
		int[] arr = new int[size + 1]; // 각 인덱스에 번호가 대응하도록 사이즈를 1더하여 배열 선언.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}

	//대상 원소가 어떤 대상을 가리키는지, 어떤 집합에 포함되어있는지(부모가 누구야) 파악하는 연산 find() 
	private static int find(int[] parent, int x) {
		if(parent[x] == x) return x; // 만일, 찾는 대상과 인덱스 번호가 같다면 그 인덱스(=노드)가 해당 집합의 부모이다.
		else return find(parent, parent[x]); // 그렇지 않다면, 해당 인덱스가 가리키는 값(부모 노드)을 따라 최종 부모노드까지 탐색한다.
	}

	private static int find_enhanced(int[] parent, int x) {
		if (parent[x] == x) return x; // 만일, 찾는 대상과 인덱스 번호가 같다면 그 인덱스(=노드)가 해당 집합의 부모이다.
		else return parent[x] = find(parent, parent[x]); // 경로 압축
	}

	private static void union_failed(int[] parent, int a, int b) {
		// 각 대상이 가리키는 부모를 구한다.
		int o1 = find(parent, a);
		int o2 = find(parent, b);

		// 부모가 작은 쪽으로 흡수해야 하므로 분기문을 나눈다.
		if (o1 > o2) parent[a] = o2; // a원소의 부모를 b원소의 부모로 바꾼다.
		else parent[b] = o1; // b원소의 부모를 a원소의 부모로 바꾼다.

		//**이렇게 하게 된다면 원소 5에 대해서만 3이 포함된 집합의 부모를 가리키게 된다..
	}

	//서로소 집합에서 '합치기 연산'은 앞서 말했지만 '두 집합을 합치는 연산'이다. 
	//따라서, 두 집합의 부모(대표자)가 다른 부모를 가리키도록 로직을 설계해주어야 한다! 
	//그렇다면 아래와 같은 코드로 구현할 수 있을 것이고, 그림은 다음과 같은 것이다.
	private static void union(int[] parent, int a, int b) { 
		// 각 집합을 대표하는 부모가 다른 부모로 편입 되어야 한다. 원소가 편입되어서는 안된다.
		a = find(parent, a);
		b = find(parent, b);
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}



}