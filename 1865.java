import java.util.*;
class Main{
	static PriorityQueue<Node> Queue;
	static ArrayList<Node>[] al;
       	static int N,M,W;
	static int[] distance;
	static boolean[][] visit;
	static class Node implements Comparable<Node>{
		int distance;
		int index;
		Node (int index, int distance){
			this.distance = distance;
			this.index = index;
		}
		public int compareTo(Node o){
			return this.distance<=o.distance ? -1:1;
		}
	}
	static int dik(int start, int end){
		for(int i = 0 ; i<=N;i++)
			distance[i] = Integer.MAX_VALUE;
		distance[start] = 0;
		Queue = new PriorityQueue<Node>();
		Queue.add(new Node(start,0));
		while(!Queue.isEmpty()){
			int curr_index = Queue.peek().index;
			int curr_distance = Queue.peek().distance;
			Queue.remove();
			for(Node node : al[curr_index]){
				int next_index = node.index;
				int next_distance = node.distance;
				System.out.println(" start" + start+" end = "+end+" " +distance[curr_index]+ " "+curr_index+" "+next_index+" "+curr_distance+ " "+next_distance);
				//if(distance[next_index]>curr_distance+next_distance&&visit[start][next_index]==false){
				if(distance[next_index]>curr_distance+next_distance&&next_index!=start){
					visit[start][next_index]=true;
					distance[next_index] = curr_distance+next_distance;
					Queue.add(new Node(next_index,next_distance));
				}
			}
		}
		return distance[end];
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int i = 0 ;i<test_case; i++){
			N = sc.nextInt();
			M = sc.nextInt();
			W = sc.nextInt();
			al = new ArrayList[N+1];
			distance = new int[N+1];
			for(int k = 0; k<N+1;k++){
				distance[k] = Integer.MAX_VALUE;
				al[k] = new ArrayList<Node>();
			}

			for(int k = 0;k<M;k++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				al[a].add(new Node(b,c));
				al[b].add(new Node(a,c));
			}
			visit = new boolean[N+1][N+1];
			for(int k = 0;k<W;k++){
				al[sc.nextInt()].add(new Node(sc.nextInt(),-sc.nextInt()));
			}
			int[][] result = new int[N+1][N+1];
			for(int k = 1; k<=N;k++){
				for(int j = k+1; j<=N;j++){
					if(k!=j){
						result[k][j] = dik(k,j);
						result[j][k] = dik(j,k);
					}
				}
			}
			int sum = 0;
			for(int k = 1; k<=N;k++){
				for(int j = 1; j<=N;j++){
					if(k!=j){
						if(result[k][j] +result[j][k] <0)
							sum=-1;
		//				System.out.println(result[k][j] +"k to j " + result[j][k] +"j to k "+ k+" k "+ j);
					}
				}
			}
			if(sum==-1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}



