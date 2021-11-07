import java.util.*;
class Main{
	static int N, M, W;
	static int Ma;
	static int curr_index;
	static int curr_distance;
	static int next_index;
	static int next_cost;
	static int[] distance ;
	static boolean[] visit;
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
	static int dik(int start, ArrayList<Node>[] dis){
		Arrays.fill(distance,Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue();
		distance[start] = 0;
		pq.add(new Node(start,0));
	
		while(!pq.isEmpty()){
			curr_index = pq.peek().index;
			curr_distance = pq.peek().cost;
			pq.remove();
			for(Node node : dis[curr_index]){
				next_index = node.index;
				next_cost = node.cost;

				if(distance[next_index]>next_cost+distance[curr_index]){
					distance[next_index] = next_cost+distance[curr_index];
					pq.add(new Node(next_index,next_cost));
				//	System.out.println(next_cost+" "+next_index+ " " + distance[next_index] );
				}
				if(next_index ==start && distance[next_index]<0)
					return -1;

			}
		}
		return 1;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int q = 0; q<test_case;q++){
			N = sc.nextInt();
			M = sc.nextInt();
			W = sc.nextInt();
			distance = new int[N+1];
			visit = new boolean[N+1];
			ArrayList<Node>[] dis = new ArrayList[N+1];
			for(int i= 1; i<=N;i++){
				dis[i] = new ArrayList<Node>();
			}
			Ma = 0;
			for(int i = 0 ; i< M;i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				dis[a].add(new Node(b,c));
				dis[b].add(new Node(a,c));
				Ma+=c;
			}
			for(int i = 0 ; i< W;i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
			//	System.out.println(a+ " "+b+" "+c);
				dis[a].add(new Node(b,c*(-1)));
			}

			int[] distance = new int[N+1];
			Arrays.fill(distance,Integer.MAX_VALUE);
			int max = 1;
			for(int a = 1; a<=N;a++)
				if(dik(a,dis) ==-1)
					max = 0;


			if(max==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
