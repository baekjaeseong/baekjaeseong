import java.util.*;
class Main{
	static int N,M;
	static int[] to;
	static int[] from;
	static int[][] cost;
	static void dijkstra(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] check = new boolean[N];
		check[start] = true;
		for(int i = 0; i<N;i++){
			if(cost[start][i]!=-1){
				if(check[i]==false){
					q.add(cost[start][i]);
					q.add(i);
					cost[start][i] = true;
				}
			}
		}
		while(!q.isEmpty()){
			int co = q.poll();
			int end = q.poll();
			if(check[end]==false){
				q.add(cost[start][i]);
				q.add(i);
				cost[start][end] = true;
			}
			else
			{
				if(cost[start][end]
			}

		}

	}
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cost = new int[N+1][N+1];
		for(int i =0; i<N;i++){
			for(int j = 0 ; j<N;j++){
				cost[i][j] =-1;
			}
		}
		for(int i = 0; i<N-1;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			cost[a][b] = sc.nextInt();
			cost[b][a] = sc.nextInt();
		}
		for(int i = 0; i<N;i++)
		dijkstra(i);


