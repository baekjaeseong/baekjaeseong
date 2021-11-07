import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int q=0; q<test_case;q++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int W = sc.nextInt();
			List<Edge> edgeList = new ArrayList<>();
			for(int i = 0 ;i<M;i++){
				int S = sc.nextInt();
				int E = sc.nextInt();
				int T = sc.nextInt();
				edgeList.add(new Edge(S,E,T));
				edgeList.add(new Edge(E,S,T));
			}
			for(int i = 0; i<W;i++){
				int S = sc.nextInt();
				int E = sc.nextInt();
				int T = sc.nextInt();
				edgeList.add(new Edge(S,E,-T));
			}
			int [] nodes = new int[N+1];
			Arrays.fill(nodes,Integer.MAX_VALUE);
			nodes[1] = 0;
			boolean isupdate = false;
outerloop:
			for(int i =1; i<=N;i++){
				isupdate = false;
				for( Edge edge : edgeList){
					if(nodes[edge.end] > nodes[edge.start]+edge.time){
						nodes[edge.end] = nodes[edge.start]+edge.time;
						isupdate = true;
						if(i==N){
							isupdate = true;
							break outerloop;
						}
					}
				}
				if(!isupdate) break;
			}
			if(isupdate)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
class Edge{
	int start, end, time;
	Edge(int start, int end, int time){
		this.start = start;
		this.end = end;
		this.time = time;
	}
}
			
