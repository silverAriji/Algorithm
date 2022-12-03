package utilize_DFS_BFS;

import java.util.Scanner;

/*
문제 : 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
	   각  문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
	   제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
	  (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
입력 : 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
	   두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
출력 : 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
*/

public class MaxScore {
	static int N, M;
	static int result = Integer.MIN_VALUE;
	
	// ps : 문제 점수
	// pt : 문제 푸는데에 걸리는 시간
	public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
		if(time > M) return;
		
		// 부분집합이 완성됨
		if(L == N) {
			result = Math.max(result, sum);
		}else {
			DFS(L+1, sum + ps[L], time + pt[L], ps, pt);
			DFS(L+1, sum, time, ps, pt);
		}
	}
	
	public static void main(String[] args) {
		MaxScore score = new MaxScore();
		Scanner sc = new Scanner(System.in);
		// 문제의 개수
		N = sc.nextInt();
		// 제한시간
		M = sc.nextInt();
		// 점수
		int[] A = new int[N];
		// 걸리는 시간
		int[] B = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		score.DFS(0, 0, 0, A, B);
		System.out.println(result);
	}
}