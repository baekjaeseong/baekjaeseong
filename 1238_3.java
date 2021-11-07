import java.util.*;
class Main{
	static int N, M, X;
	static ArrayList<Node>[] dis;

	static class Node implements Comparable<Node>{
		int index;
		int cost;
		Node(int index, int cost){
			this.index = index;
			this.cost = cost;
		}
		public int compareTo(Node o){
			return this.cost - o.cost;
		}
	}
	static int dik(int start, int end){
		int[] distance = new int[N+1];
		Arrays.fill(distance,Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue();
		distance[start] = 0;
		pq.add(new Node(start,0));
		boolean[] visit = new boolean[N+1];
		while(!pq.isEmpty()){
			int curr_index = pq.peek().index;
			int curr_distance = pq.peek().cost;
			pq.remove();
						if(visit[curr_index]==true) continue;
			visit[curr_index] = true;
			for(Node node : dis[curr_index]){
				int next_index = node.index;
				int next_cost = node.cost;
				if(distance[next_index]>next_cost+distance[curr_index]){
					distance[next_index] = next_cost+distance[curr_index];
					pq.add(new Node(next_index,next_cost));
				}
//				System.out.println(next_cost+" "+next_index);

			}
//			System.out.println("dd");
		}
		return distance[end];
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		dis = new ArrayList[N+1];
		for(int i= 1; i<=N;i++){
			dis[i] = new ArrayList<Node>();
		}
		for(int i = 0 ; i< M;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dis[a].add(new Node(b,c));
		}
		int[] distance = new int[N+1];
		for(int a = 1; a<=N;a++)
			distance[a] = dik(a,X)+dik(X,a);

		int max = 0;
		for(int a = 1; a<=N;a++)
			max = Math.max(max,distance[a]);
		System.out.println(max);
	}
}
