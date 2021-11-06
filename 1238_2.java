import java.util.*;
class Main{
	static PriorityQueue<Node> queue;
	static ArrayList<Node>[] al;
	static int distance[];
	static int n,m,x;
	static int Max = Integer.MIN_VALUE;
	static class Node implements Comparable<Node>{
		int distance;
		int index;
		Node(int index, int distance){
			this.index = index;
			this. distance = distance;
		}
		public int compareTo(Node o){
			return this.distance <=o.distance ? -1:1;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		distance = new int[n+1];
		queue = new PriorityQueue<>();
		al = new ArrayList[n+1];
		for (int i = 0; i<=n;i++){
			distance[i] = Integer.MAX_VALUE;
			al[i] = new ArrayList<Node>();
		}
		for (int i = 0; i<m;i++){
			al[sc.nextInt()].add(new Node(sc.nextInt(),sc.nextInt()));
		}
		int result[] = new int[n+1];
		for(int i = 1; i<=n;i++){
			result[i] = dijkstra(i,x) + dijkstra(x,i);
			Max = Math.max(result[i], Max);
		}
		System.out.println(Max);
	}
	public static int dijkstra(int start, int end){
		for(int k = 0; k<=n; k++){
			distance[k] = Integer.MAX_VALUE;
		}
		queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.add(new Node(start,0));
		while(!queue.isEmpty()){
			int current_index = queue.peek().index;
			int current_distance = queue.peek().distance;
			queue.remove();
			for(Node node : al[current_index]){
				int next_index = node.index;
				int next_distance = node.distance;
				if(distance[next_index]>current_distance + next_distance){
					distance[next_index] = current_distance + next_distance;
					queue.add(new Node(next_index,distance[next_index]));
				}
			}
		}
		return distance[end];
	}
}

